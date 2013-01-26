package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class CreateOperationCommandFacade{

	private String schemaName;
	private Connection con;

	public CreateOperationCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CreateOperationCommandProxi newCreateOperationCommand(String name,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtOprtnCMDFacade.newCrtOprtnCMD(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateOperationCommand result = new CreateOperationCommand(null,null,name,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateOperationCommandProxi)PersistentProxi.createProxi(id, 178);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateOperationCommandProxi newDelayedCreateOperationCommand(String name) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtOprtnCMDFacade.newDelayedCrtOprtnCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateOperationCommand result = new CreateOperationCommand(null,null,name,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateOperationCommandProxi)PersistentProxi.createProxi(id, 178);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateOperationCommand getCreateOperationCommand(long CreateOperationCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtOprtnCMDFacade.getCrtOprtnCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CreateOperationCommandId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentMType source = null;
            if (obj.getLong(2) != 0)
                source = (PersistentMType)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentMType target = null;
            if (obj.getLong(4) != 0)
                target = (PersistentMType)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            Invoker invoker = null;
            if (obj.getLong(7) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            PersistentOperationManager commandReceiver = null;
            if (obj.getLong(9) != 0)
                commandReceiver = (PersistentOperationManager)PersistentProxi.createProxi(obj.getLong(9), obj.getLong(10));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(11) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(11), obj.getLong(12));
            CreateOperationCommand result = new CreateOperationCommand(source,
                                                                       target,
                                                                       obj.getString(6) == null ? "" : obj.getString(6) /* In Oracle "" = null !!! */,
                                                                       invoker,
                                                                       commandReceiver,
                                                                       myCommonDate,
                                                                       CreateOperationCommandId);
            obj.close();
            callable.close();
            CreateOperationCommandICProxi inCache = (CreateOperationCommandICProxi)Cache.getTheCache().put(result);
            CreateOperationCommand objectInCache = (CreateOperationCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtOprtnCMDFacade.getClass(?); end;");
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
    public void sourceSet(long CreateOperationCommandId, PersistentMType sourceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtOprtnCMDFacade.srcSet(?, ?, ?); end;");
            callable.setLong(1, CreateOperationCommandId);
            callable.setLong(2, sourceVal.getId());
            callable.setLong(3, sourceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void targetSet(long CreateOperationCommandId, PersistentMType targetVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtOprtnCMDFacade.trgtSet(?, ?, ?); end;");
            callable.setLong(1, CreateOperationCommandId);
            callable.setLong(2, targetVal.getId());
            callable.setLong(3, targetVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void nameSet(long CreateOperationCommandId, String nameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtOprtnCMDFacade.nmSet(?, ?); end;");
            callable.setLong(1, CreateOperationCommandId);
            callable.setString(2, nameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long fpAdd(long CreateOperationCommandId, PersistentFormalParameter fpVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtOprtnCMDFacade.fpAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, CreateOperationCommandId);
            callable.setLong(3, fpVal.getId());
            callable.setLong(4, fpVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void fpRem(long fpId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtOprtnCMDFacade.fpRem(?); end;");
            callable.setLong(1, fpId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public FormalParameterList fpGet(long CreateOperationCommandId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtOprtnCMDFacade.fpGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CreateOperationCommandId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            FormalParameterList result = new FormalParameterList();
            while (list.next()) {
                result.add((PersistentFormalParameter)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long CreateOperationCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtOprtnCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, CreateOperationCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long CreateOperationCommandId, PersistentOperationManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtOprtnCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, CreateOperationCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long CreateOperationCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtOprtnCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, CreateOperationCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

