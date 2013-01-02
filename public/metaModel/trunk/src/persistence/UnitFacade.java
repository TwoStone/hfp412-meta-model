package persistence;

import model.quantity.*;

import java.sql.*;
import oracle.jdbc.*;

public class UnitFacade{

	private String schemaName;
	private Connection con;

	public UnitFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public UnitProxi newUnit(String name,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".UntFacade.newUnt(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Unit result = new Unit(null,name,null,id);
            Cache.getTheCache().put(result);
            return (UnitProxi)PersistentProxi.createProxi(id, 153);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public UnitProxi newDelayedUnit(String name) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".UntFacade.newDelayedUnt(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Unit result = new Unit(null,name,null,id);
            Cache.getTheCache().put(result);
            return (UnitProxi)PersistentProxi.createProxi(id, 153);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Unit getUnit(long UnitId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".UntFacade.getUnt(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, UnitId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentAbsUnitType type = null;
            if (obj.getLong(2) != 0)
                type = (PersistentAbsUnitType)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentAbsUnit This = null;
            if (obj.getLong(5) != 0)
                This = (PersistentAbsUnit)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            Unit result = new Unit(type,
                                   obj.getString(4) == null ? "" : obj.getString(4) /* In Oracle "" = null !!! */,
                                   This,
                                   UnitId);
            obj.close();
            callable.close();
            UnitICProxi inCache = (UnitICProxi)Cache.getTheCache().put(result);
            Unit objectInCache = (Unit)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

