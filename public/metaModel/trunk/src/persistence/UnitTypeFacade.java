package persistence;

import model.quantity.*;

import java.sql.*;
import oracle.jdbc.*;

public class UnitTypeFacade{

	private String schemaName;
	private Connection con;

	public UnitTypeFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public UnitTypeProxi newUnitType(String name,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".UntTpFacade.newUntTp(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            UnitType result = new UnitType(name,null,null,id);
            Cache.getTheCache().put(result);
            return (UnitTypeProxi)PersistentProxi.createProxi(id, 184);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public UnitTypeProxi newDelayedUnitType(String name) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".UntTpFacade.newDelayedUntTp(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            UnitType result = new UnitType(name,null,null,id);
            Cache.getTheCache().put(result);
            return (UnitTypeProxi)PersistentProxi.createProxi(id, 184);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public UnitType getUnitType(long UnitTypeId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".UntTpFacade.getUntTp(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, UnitTypeId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentAbsUnitType This = null;
            if (obj.getLong(3) != 0)
                This = (PersistentAbsUnitType)PersistentProxi.createProxi(obj.getLong(3), obj.getLong(4));
            PersistentUnit defaultUnit = null;
            if (obj.getLong(5) != 0)
                defaultUnit = (PersistentUnit)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            UnitType result = new UnitType(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                           This,
                                           defaultUnit,
                                           UnitTypeId);
            obj.close();
            callable.close();
            UnitTypeICProxi inCache = (UnitTypeICProxi)Cache.getTheCache().put(result);
            UnitType objectInCache = (UnitType)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void defaultUnitSet(long UnitTypeId, PersistentUnit defaultUnitVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".UntTpFacade.dfltUntSet(?, ?, ?); end;");
            callable.setLong(1, UnitTypeId);
            callable.setLong(2, defaultUnitVal.getId());
            callable.setLong(3, defaultUnitVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

