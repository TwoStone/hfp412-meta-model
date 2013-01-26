package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class CreateStaticMessageCommandFacade{

	private String schemaName;
	private Connection con;

	public CreateStaticMessageCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CreateStaticMessageCommandProxi newCreateStaticMessageCommand(String name,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtSttcMssgCMDFacade.newCrtSttcMssgCMD(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateStaticMessageCommand result = new CreateStaticMessageCommand(null,name,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateStaticMessageCommandProxi)PersistentProxi.createProxi(id, 168);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateStaticMessageCommandProxi newDelayedCreateStaticMessageCommand(String name) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtSttcMssgCMDFacade.newDelayedCrtSttcMssgCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateStaticMessageCommand result = new CreateStaticMessageCommand(null,name,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateStaticMessageCommandProxi)PersistentProxi.createProxi(id, 168);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateStaticMessageCommand getCreateStaticMessageCommand(long CreateStaticMessageCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtSttcMssgCMDFacade.getCrtSttcMssgCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CreateStaticMessageCommandId);
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
            PersistentInstanceObject target = null;
            if (obj.getLong(5) != 0)
                target = (PersistentInstanceObject)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            Invoker invoker = null;
            if (obj.getLong(7) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            PersistentMessageManager commandReceiver = null;
            if (obj.getLong(9) != 0)
                commandReceiver = (PersistentMessageManager)PersistentProxi.createProxi(obj.getLong(9), obj.getLong(10));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(11) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(11), obj.getLong(12));
            CreateStaticMessageCommand result = new CreateStaticMessageCommand(type,
                                                                               obj.getString(4) == null ? "" : obj.getString(4) /* In Oracle "" = null !!! */,
                                                                               target,
                                                                               invoker,
                                                                               commandReceiver,
                                                                               myCommonDate,
                                                                               CreateStaticMessageCommandId);
            obj.close();
            callable.close();
            CreateStaticMessageCommandICProxi inCache = (CreateStaticMessageCommandICProxi)Cache.getTheCache().put(result);
            CreateStaticMessageCommand objectInCache = (CreateStaticMessageCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtSttcMssgCMDFacade.getClass(?); end;");
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
    public void typeSet(long CreateStaticMessageCommandId, PersistentOperation typeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtSttcMssgCMDFacade.tpSet(?, ?, ?); end;");
            callable.setLong(1, CreateStaticMessageCommandId);
            callable.setLong(2, typeVal.getId());
            callable.setLong(3, typeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void nameSet(long CreateStaticMessageCommandId, String nameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtSttcMssgCMDFacade.nmSet(?, ?); end;");
            callable.setLong(1, CreateStaticMessageCommandId);
            callable.setString(2, nameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void targetSet(long CreateStaticMessageCommandId, PersistentInstanceObject targetVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtSttcMssgCMDFacade.trgtSet(?, ?, ?); end;");
            callable.setLong(1, CreateStaticMessageCommandId);
            callable.setLong(2, targetVal.getId());
            callable.setLong(3, targetVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long apAdd(long CreateStaticMessageCommandId, PersistentActualParameter apVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtSttcMssgCMDFacade.apAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, CreateStaticMessageCommandId);
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
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtSttcMssgCMDFacade.apRem(?); end;");
            callable.setLong(1, apId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public ActualParameterList apGet(long CreateStaticMessageCommandId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtSttcMssgCMDFacade.apGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CreateStaticMessageCommandId);
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
    public void invokerSet(long CreateStaticMessageCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtSttcMssgCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, CreateStaticMessageCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long CreateStaticMessageCommandId, PersistentMessageManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtSttcMssgCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, CreateStaticMessageCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long CreateStaticMessageCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtSttcMssgCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, CreateStaticMessageCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

