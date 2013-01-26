package persistence;

import model.measurement.*;

import java.sql.*;
import oracle.jdbc.*;

public class MAccountTypeFacade{

	private String schemaName;
	private Connection con;

	public MAccountTypeFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public MAccountTypeProxi newMAccountType(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MAccntTpFacade.newMAccntTp(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            MAccountType result = new MAccountType(null,null,null,id);
            Cache.getTheCache().put(result);
            return (MAccountTypeProxi)PersistentProxi.createProxi(id, 166);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MAccountTypeProxi newDelayedMAccountType() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MAccntTpFacade.newDelayedMAccntTp(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            MAccountType result = new MAccountType(null,null,null,id);
            Cache.getTheCache().put(result);
            return (MAccountTypeProxi)PersistentProxi.createProxi(id, 166);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MAccountType getMAccountType(long MAccountTypeId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MAccntTpFacade.getMAccntTp(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, MAccountTypeId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentMType type = null;
            if (obj.getLong(2) != 0)
                type = (PersistentMType)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentAbsUnitType unitType = null;
            if (obj.getLong(4) != 0)
                unitType = (PersistentAbsUnitType)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentMQuantiObjectType This = null;
            if (obj.getLong(6) != 0)
                This = (PersistentMQuantiObjectType)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            MAccountType result = new MAccountType(type,
                                                   unitType,
                                                   This,
                                                   MAccountTypeId);
            obj.close();
            callable.close();
            MAccountTypeICProxi inCache = (MAccountTypeICProxi)Cache.getTheCache().put(result);
            MAccountType objectInCache = (MAccountType)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long subAccountTypesAdd(long MAccountTypeId, PersistentMAccountType subAccountTypesVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MAccntTpFacade.sbAccntTpsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, MAccountTypeId);
            callable.setLong(3, subAccountTypesVal.getId());
            callable.setLong(4, subAccountTypesVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subAccountTypesRem(long subAccountTypesId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MAccntTpFacade.sbAccntTpsRem(?); end;");
            callable.setLong(1, subAccountTypesId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public MAccountTypeList subAccountTypesGet(long MAccountTypeId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MAccntTpFacade.sbAccntTpsGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, MAccountTypeId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            MAccountTypeList result = new MAccountTypeList();
            while (list.next()) {
                result.add((PersistentMAccountType)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

