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
            UnitType result = new UnitType(null,name,null,id);
            Cache.getTheCache().put(result);
            return (UnitTypeProxi)PersistentProxi.createProxi(id, 152);
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
            UnitType result = new UnitType(null,name,null,id);
            Cache.getTheCache().put(result);
            return (UnitTypeProxi)PersistentProxi.createProxi(id, 152);
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
            PersistentAbsUnit defaultUnit = null;
            if (obj.getLong(2) != 0)
                defaultUnit = (PersistentAbsUnit)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentAbsUnitType This = null;
            if (obj.getLong(5) != 0)
                This = (PersistentAbsUnitType)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            UnitType result = new UnitType(defaultUnit,
                                           obj.getString(4) == null ? "" : obj.getString(4) /* In Oracle "" = null !!! */,
                                           This,
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

}

