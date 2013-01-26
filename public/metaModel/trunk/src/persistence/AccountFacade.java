package persistence;

import model.measurement.*;

import java.sql.*;
import oracle.jdbc.*;

public class AccountFacade{

	private String schemaName;
	private Connection con;

	public AccountFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public AccountProxi newAccount(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntFacade.newAccnt(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Account result = new Account(null,null,null,id);
            Cache.getTheCache().put(result);
            return (AccountProxi)PersistentProxi.createProxi(id, 183);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AccountProxi newDelayedAccount() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntFacade.newDelayedAccnt(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Account result = new Account(null,null,null,id);
            Cache.getTheCache().put(result);
            return (AccountProxi)PersistentProxi.createProxi(id, 183);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Account getAccount(long AccountId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntFacade.getAccnt(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AccountId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentInstanceObject object = null;
            if (obj.getLong(2) != 0)
                object = (PersistentInstanceObject)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentQuantifObject This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentQuantifObject)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentMAccountType type = null;
            if (obj.getLong(6) != 0)
                type = (PersistentMAccountType)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            Account result = new Account(object,
                                         This,
                                         type,
                                         AccountId);
            obj.close();
            callable.close();
            AccountICProxi inCache = (AccountICProxi)Cache.getTheCache().put(result);
            Account objectInCache = (Account)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void typeSet(long AccountId, PersistentMAccountType typeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntFacade.tpSet(?, ?, ?); end;");
            callable.setLong(1, AccountId);
            callable.setLong(2, typeVal.getId());
            callable.setLong(3, typeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long subAccountsAdd(long AccountId, PersistentAccount subAccountsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntFacade.sbAccntsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, AccountId);
            callable.setLong(3, subAccountsVal.getId());
            callable.setLong(4, subAccountsVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subAccountsRem(long subAccountsId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntFacade.sbAccntsRem(?); end;");
            callable.setLong(1, subAccountsId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public AccountList subAccountsGet(long AccountId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntFacade.sbAccntsGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AccountId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            AccountList result = new AccountList();
            while (list.next()) {
                result.add((PersistentAccount)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long entriesAdd(long AccountId, PersistentMeasurement entriesVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntFacade.entrsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, AccountId);
            callable.setLong(3, entriesVal.getId());
            callable.setLong(4, entriesVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void entriesRem(long entriesId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntFacade.entrsRem(?); end;");
            callable.setLong(1, entriesId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public MeasurementList entriesGet(long AccountId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntFacade.entrsGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AccountId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            MeasurementList result = new MeasurementList();
            while (list.next()) {
                result.add((PersistentMeasurement)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

