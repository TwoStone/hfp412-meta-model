package persistence;

import model.quantity.*;

import java.sql.*;
import oracle.jdbc.*;

public class UnitTypeManagerFacade{

	private String schemaName;
	private Connection con;

	public UnitTypeManagerFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public UnitTypeManagerProxi getTheUnitTypeManager() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".UntTpMngrFacade.getTheUntTpMngr; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (UnitTypeManagerProxi)PersistentProxi.createProxi(id, 171);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public UnitTypeManager getUnitTypeManager(long UnitTypeManagerId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".UntTpMngrFacade.getUntTpMngr(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, UnitTypeManagerId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentUnitTypeManager This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentUnitTypeManager)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            UnitTypeManager result = new UnitTypeManager(This,
                                                         UnitTypeManagerId);
            obj.close();
            callable.close();
            UnitTypeManagerICProxi inCache = (UnitTypeManagerICProxi)Cache.getTheCache().put(result);
            UnitTypeManager objectInCache = (UnitTypeManager)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".UntTpMngrFacade.getClass(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, objectId);
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long unitTypesAdd(long UnitTypeManagerId, PersistentAbsUnitType unitTypesVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".UntTpMngrFacade.untTpsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, UnitTypeManagerId);
            callable.setLong(3, unitTypesVal.getId());
            callable.setLong(4, unitTypesVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void unitTypesRem(long unitTypesId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".UntTpMngrFacade.untTpsRem(?); end;");
            callable.setLong(1, unitTypesId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public AbsUnitTypeList unitTypesGet(long UnitTypeManagerId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".UntTpMngrFacade.untTpsGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, UnitTypeManagerId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            AbsUnitTypeList result = new AbsUnitTypeList();
            while (list.next()) {
                result.add((PersistentAbsUnitType)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long unitsAdd(long UnitTypeManagerId, PersistentAbsUnit unitsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".UntTpMngrFacade.untsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, UnitTypeManagerId);
            callable.setLong(3, unitsVal.getId());
            callable.setLong(4, unitsVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void unitsRem(long unitsId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".UntTpMngrFacade.untsRem(?); end;");
            callable.setLong(1, unitsId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public AbsUnitList unitsGet(long UnitTypeManagerId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".UntTpMngrFacade.untsGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, UnitTypeManagerId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            AbsUnitList result = new AbsUnitList();
            while (list.next()) {
                result.add((PersistentAbsUnit)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long UnitTypeManagerId, PersistentUnitTypeManager ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".UntTpMngrFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, UnitTypeManagerId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

