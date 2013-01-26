package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class CreateFpCommandFacade{

	private String schemaName;
	private Connection con;

	public CreateFpCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CreateFpCommandProxi newCreateFpCommand(String name,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtFpCMDFacade.newCrtFpCMD(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateFpCommand result = new CreateFpCommand(name,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateFpCommandProxi)PersistentProxi.createProxi(id, 201);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateFpCommandProxi newDelayedCreateFpCommand(String name) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtFpCMDFacade.newDelayedCrtFpCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateFpCommand result = new CreateFpCommand(name,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateFpCommandProxi)PersistentProxi.createProxi(id, 201);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateFpCommand getCreateFpCommand(long CreateFpCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtFpCMDFacade.getCrtFpCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CreateFpCommandId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentMType ofType = null;
            if (obj.getLong(3) != 0)
                ofType = (PersistentMType)PersistentProxi.createProxi(obj.getLong(3), obj.getLong(4));
            Invoker invoker = null;
            if (obj.getLong(5) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            PersistentOperationManager commandReceiver = null;
            if (obj.getLong(7) != 0)
                commandReceiver = (PersistentOperationManager)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(9) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(9), obj.getLong(10));
            CreateFpCommand result = new CreateFpCommand(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                                         ofType,
                                                         invoker,
                                                         commandReceiver,
                                                         myCommonDate,
                                                         CreateFpCommandId);
            obj.close();
            callable.close();
            CreateFpCommandICProxi inCache = (CreateFpCommandICProxi)Cache.getTheCache().put(result);
            CreateFpCommand objectInCache = (CreateFpCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtFpCMDFacade.getClass(?); end;");
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
    public void nameSet(long CreateFpCommandId, String nameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtFpCMDFacade.nmSet(?, ?); end;");
            callable.setLong(1, CreateFpCommandId);
            callable.setString(2, nameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ofTypeSet(long CreateFpCommandId, PersistentMType ofTypeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtFpCMDFacade.ofTpSet(?, ?, ?); end;");
            callable.setLong(1, CreateFpCommandId);
            callable.setLong(2, ofTypeVal.getId());
            callable.setLong(3, ofTypeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long CreateFpCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtFpCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, CreateFpCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long CreateFpCommandId, PersistentOperationManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtFpCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, CreateFpCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long CreateFpCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtFpCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, CreateFpCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

