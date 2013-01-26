package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class CreateAccountCommandFacade{

	private String schemaName;
	private Connection con;

	public CreateAccountCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CreateAccountCommandProxi newCreateAccountCommand(String name,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtAccntCMDFacade.newCrtAccntCMD(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateAccountCommand result = new CreateAccountCommand(name,null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateAccountCommandProxi)PersistentProxi.createProxi(id, 155);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateAccountCommandProxi newDelayedCreateAccountCommand(String name) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtAccntCMDFacade.newDelayedCrtAccntCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateAccountCommand result = new CreateAccountCommand(name,null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateAccountCommandProxi)PersistentProxi.createProxi(id, 155);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateAccountCommand getCreateAccountCommand(long CreateAccountCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtAccntCMDFacade.getCrtAccntCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CreateAccountCommandId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentMAccountType type = null;
            if (obj.getLong(3) != 0)
                type = (PersistentMAccountType)PersistentProxi.createProxi(obj.getLong(3), obj.getLong(4));
            PersistentInstanceObject object = null;
            if (obj.getLong(5) != 0)
                object = (PersistentInstanceObject)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            Invoker invoker = null;
            if (obj.getLong(7) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            PersistentAccountManager commandReceiver = null;
            if (obj.getLong(9) != 0)
                commandReceiver = (PersistentAccountManager)PersistentProxi.createProxi(obj.getLong(9), obj.getLong(10));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(11) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(11), obj.getLong(12));
            CreateAccountCommand result = new CreateAccountCommand(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                                                   type,
                                                                   object,
                                                                   invoker,
                                                                   commandReceiver,
                                                                   myCommonDate,
                                                                   CreateAccountCommandId);
            obj.close();
            callable.close();
            CreateAccountCommandICProxi inCache = (CreateAccountCommandICProxi)Cache.getTheCache().put(result);
            CreateAccountCommand objectInCache = (CreateAccountCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtAccntCMDFacade.getClass(?); end;");
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
    public void nameSet(long CreateAccountCommandId, String nameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAccntCMDFacade.nmSet(?, ?); end;");
            callable.setLong(1, CreateAccountCommandId);
            callable.setString(2, nameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void typeSet(long CreateAccountCommandId, PersistentMAccountType typeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAccntCMDFacade.tpSet(?, ?, ?); end;");
            callable.setLong(1, CreateAccountCommandId);
            callable.setLong(2, typeVal.getId());
            callable.setLong(3, typeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void objectSet(long CreateAccountCommandId, PersistentInstanceObject objectVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAccntCMDFacade.objctSet(?, ?, ?); end;");
            callable.setLong(1, CreateAccountCommandId);
            callable.setLong(2, objectVal.getId());
            callable.setLong(3, objectVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long CreateAccountCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAccntCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, CreateAccountCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long CreateAccountCommandId, PersistentAccountManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAccntCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, CreateAccountCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long CreateAccountCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAccntCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, CreateAccountCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

