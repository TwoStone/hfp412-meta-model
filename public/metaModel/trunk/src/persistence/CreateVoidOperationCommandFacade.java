package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class CreateVoidOperationCommandFacade{

	private String schemaName;
	private Connection con;

	public CreateVoidOperationCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CreateVoidOperationCommandProxi newCreateVoidOperationCommand(String name,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtVdOprtnCMDFacade.newCrtVdOprtnCMD(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateVoidOperationCommand result = new CreateVoidOperationCommand(null,name,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateVoidOperationCommandProxi)PersistentProxi.createProxi(id, 159);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateVoidOperationCommandProxi newDelayedCreateVoidOperationCommand(String name) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtVdOprtnCMDFacade.newDelayedCrtVdOprtnCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateVoidOperationCommand result = new CreateVoidOperationCommand(null,name,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateVoidOperationCommandProxi)PersistentProxi.createProxi(id, 159);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateVoidOperationCommand getCreateVoidOperationCommand(long CreateVoidOperationCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtVdOprtnCMDFacade.getCrtVdOprtnCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CreateVoidOperationCommandId);
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
            Invoker invoker = null;
            if (obj.getLong(5) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            PersistentOperationManager commandReceiver = null;
            if (obj.getLong(7) != 0)
                commandReceiver = (PersistentOperationManager)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(9) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(9), obj.getLong(10));
            CreateVoidOperationCommand result = new CreateVoidOperationCommand(source,
                                                                               obj.getString(4) == null ? "" : obj.getString(4) /* In Oracle "" = null !!! */,
                                                                               invoker,
                                                                               commandReceiver,
                                                                               myCommonDate,
                                                                               CreateVoidOperationCommandId);
            obj.close();
            callable.close();
            CreateVoidOperationCommandICProxi inCache = (CreateVoidOperationCommandICProxi)Cache.getTheCache().put(result);
            CreateVoidOperationCommand objectInCache = (CreateVoidOperationCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtVdOprtnCMDFacade.getClass(?); end;");
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
    public void sourceSet(long CreateVoidOperationCommandId, PersistentMType sourceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtVdOprtnCMDFacade.srcSet(?, ?, ?); end;");
            callable.setLong(1, CreateVoidOperationCommandId);
            callable.setLong(2, sourceVal.getId());
            callable.setLong(3, sourceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void nameSet(long CreateVoidOperationCommandId, String nameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtVdOprtnCMDFacade.nmSet(?, ?); end;");
            callable.setLong(1, CreateVoidOperationCommandId);
            callable.setString(2, nameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long fpAdd(long CreateVoidOperationCommandId, PersistentFormalParameter fpVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtVdOprtnCMDFacade.fpAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, CreateVoidOperationCommandId);
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
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtVdOprtnCMDFacade.fpRem(?); end;");
            callable.setLong(1, fpId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public FormalParameterList fpGet(long CreateVoidOperationCommandId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtVdOprtnCMDFacade.fpGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CreateVoidOperationCommandId);
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
    public void invokerSet(long CreateVoidOperationCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtVdOprtnCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, CreateVoidOperationCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long CreateVoidOperationCommandId, PersistentOperationManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtVdOprtnCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, CreateVoidOperationCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long CreateVoidOperationCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtVdOprtnCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, CreateVoidOperationCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

