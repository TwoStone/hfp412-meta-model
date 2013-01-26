package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class CreateVoidMessageCommandFacade{

	private String schemaName;
	private Connection con;

	public CreateVoidMessageCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CreateVoidMessageCommandProxi newCreateVoidMessageCommand(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtVdMssgCMDFacade.newCrtVdMssgCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateVoidMessageCommand result = new CreateVoidMessageCommand(null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateVoidMessageCommandProxi)PersistentProxi.createProxi(id, 173);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateVoidMessageCommandProxi newDelayedCreateVoidMessageCommand() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtVdMssgCMDFacade.newDelayedCrtVdMssgCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateVoidMessageCommand result = new CreateVoidMessageCommand(null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateVoidMessageCommandProxi)PersistentProxi.createProxi(id, 173);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateVoidMessageCommand getCreateVoidMessageCommand(long CreateVoidMessageCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtVdMssgCMDFacade.getCrtVdMssgCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CreateVoidMessageCommandId);
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
            Invoker invoker = null;
            if (obj.getLong(6) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentMessageManager commandReceiver = null;
            if (obj.getLong(8) != 0)
                commandReceiver = (PersistentMessageManager)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(10) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(10), obj.getLong(11));
            CreateVoidMessageCommand result = new CreateVoidMessageCommand(type,
                                                                           source,
                                                                           invoker,
                                                                           commandReceiver,
                                                                           myCommonDate,
                                                                           CreateVoidMessageCommandId);
            obj.close();
            callable.close();
            CreateVoidMessageCommandICProxi inCache = (CreateVoidMessageCommandICProxi)Cache.getTheCache().put(result);
            CreateVoidMessageCommand objectInCache = (CreateVoidMessageCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtVdMssgCMDFacade.getClass(?); end;");
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
    public void typeSet(long CreateVoidMessageCommandId, PersistentOperation typeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtVdMssgCMDFacade.tpSet(?, ?, ?); end;");
            callable.setLong(1, CreateVoidMessageCommandId);
            callable.setLong(2, typeVal.getId());
            callable.setLong(3, typeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void sourceSet(long CreateVoidMessageCommandId, PersistentInstanceObject sourceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtVdMssgCMDFacade.srcSet(?, ?, ?); end;");
            callable.setLong(1, CreateVoidMessageCommandId);
            callable.setLong(2, sourceVal.getId());
            callable.setLong(3, sourceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long apAdd(long CreateVoidMessageCommandId, PersistentActualParameter apVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtVdMssgCMDFacade.apAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, CreateVoidMessageCommandId);
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
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtVdMssgCMDFacade.apRem(?); end;");
            callable.setLong(1, apId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public ActualParameterList apGet(long CreateVoidMessageCommandId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtVdMssgCMDFacade.apGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CreateVoidMessageCommandId);
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
    public void invokerSet(long CreateVoidMessageCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtVdMssgCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, CreateVoidMessageCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long CreateVoidMessageCommandId, PersistentMessageManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtVdMssgCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, CreateVoidMessageCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long CreateVoidMessageCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtVdMssgCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, CreateVoidMessageCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

