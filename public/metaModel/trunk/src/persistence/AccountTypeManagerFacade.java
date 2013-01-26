package persistence;

import model.measurement.*;

import java.sql.*;
import oracle.jdbc.*;

public class AccountTypeManagerFacade{

	private String schemaName;
	private Connection con;

	public AccountTypeManagerFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public AccountTypeManagerProxi getTheAccountTypeManager() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntTpMngrFacade.getTheAccntTpMngr; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (AccountTypeManagerProxi)PersistentProxi.createProxi(id, 129);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AccountTypeManager getAccountTypeManager(long AccountTypeManagerId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntTpMngrFacade.getAccntTpMngr(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AccountTypeManagerId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentAccountTypeManager This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentAccountTypeManager)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            AccountTypeManager result = new AccountTypeManager(This,
                                                               AccountTypeManagerId);
            obj.close();
            callable.close();
            AccountTypeManagerICProxi inCache = (AccountTypeManagerICProxi)Cache.getTheCache().put(result);
            AccountTypeManager objectInCache = (AccountTypeManager)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntTpMngrFacade.getClass(?); end;");
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
    public long accountTypesAdd(long AccountTypeManagerId, PersistentMAccountType accountTypesVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntTpMngrFacade.accntTpsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, AccountTypeManagerId);
            callable.setLong(3, accountTypesVal.getId());
            callable.setLong(4, accountTypesVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void accountTypesRem(long accountTypesId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntTpMngrFacade.accntTpsRem(?); end;");
            callable.setLong(1, accountTypesId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public MAccountTypeList accountTypesGet(long AccountTypeManagerId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntTpMngrFacade.accntTpsGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AccountTypeManagerId);
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
    public void ThisSet(long AccountTypeManagerId, PersistentAccountTypeManager ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntTpMngrFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, AccountTypeManagerId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

