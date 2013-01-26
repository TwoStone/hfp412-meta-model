package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class CreateMessageCommandFacade{

	private String schemaName;
	private Connection con;

	public CreateMessageCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CreateMessageCommandProxi newCreateMessageCommand(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtMssgCMDFacade.newCrtMssgCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateMessageCommand result = new CreateMessageCommand(null,null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateMessageCommandProxi)PersistentProxi.createProxi(id, 146);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateMessageCommandProxi newDelayedCreateMessageCommand() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtMssgCMDFacade.newDelayedCrtMssgCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateMessageCommand result = new CreateMessageCommand(null,null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateMessageCommandProxi)PersistentProxi.createProxi(id, 146);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateMessageCommand getCreateMessageCommand(long CreateMessageCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtMssgCMDFacade.getCrtMssgCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CreateMessageCommandId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentOperation type = null;
            if (obj.getLong(2) != 0)
                type = (PersistentOperation)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentInstanceObject source = null;
            if (obj.getLong(4) != 0)
                source = (PersistentInstanceObject)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentInstanceObject target = null;
            if (obj.getLong(6) != 0)
                target = (PersistentInstanceObject)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            Invoker invoker = null;
            if (obj.getLong(8) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            PersistentMessageManager commandReceiver = null;
            if (obj.getLong(10) != 0)
                commandReceiver = (PersistentMessageManager)PersistentProxi.createProxi(obj.getLong(10), obj.getLong(11));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(12) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(12), obj.getLong(13));
            CreateMessageCommand result = new CreateMessageCommand(type,
                                                                   source,
                                                                   target,
                                                                   invoker,
                                                                   commandReceiver,
                                                                   myCommonDate,
                                                                   CreateMessageCommandId);
            obj.close();
            callable.close();
            CreateMessageCommandICProxi inCache = (CreateMessageCommandICProxi)Cache.getTheCache().put(result);
            CreateMessageCommand objectInCache = (CreateMessageCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtMssgCMDFacade.getClass(?); end;");
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
    public void typeSet(long CreateMessageCommandId, PersistentOperation typeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtMssgCMDFacade.tpSet(?, ?, ?); end;");
            callable.setLong(1, CreateMessageCommandId);
            callable.setLong(2, typeVal.getId());
            callable.setLong(3, typeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void sourceSet(long CreateMessageCommandId, PersistentInstanceObject sourceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtMssgCMDFacade.srcSet(?, ?, ?); end;");
            callable.setLong(1, CreateMessageCommandId);
            callable.setLong(2, sourceVal.getId());
            callable.setLong(3, sourceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void targetSet(long CreateMessageCommandId, PersistentInstanceObject targetVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtMssgCMDFacade.trgtSet(?, ?, ?); end;");
            callable.setLong(1, CreateMessageCommandId);
            callable.setLong(2, targetVal.getId());
            callable.setLong(3, targetVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long apAdd(long CreateMessageCommandId, PersistentActualParameter apVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtMssgCMDFacade.apAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, CreateMessageCommandId);
            callable.setLong(3, apVal.getId());
            callable.setLong(4, apVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void apRem(long apId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtMssgCMDFacade.apRem(?); end;");
            callable.setLong(1, apId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public ActualParameterList apGet(long CreateMessageCommandId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtMssgCMDFacade.apGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CreateMessageCommandId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            ActualParameterList result = new ActualParameterList();
            while (list.next()) {
                result.add((PersistentActualParameter)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long CreateMessageCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtMssgCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, CreateMessageCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long CreateMessageCommandId, PersistentMessageManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtMssgCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, CreateMessageCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long CreateMessageCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtMssgCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, CreateMessageCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

