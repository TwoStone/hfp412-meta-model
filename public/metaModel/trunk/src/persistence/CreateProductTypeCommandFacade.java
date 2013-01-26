package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class CreateProductTypeCommandFacade{

	private String schemaName;
	private Connection con;

	public CreateProductTypeCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CreateProductTypeCommandProxi newCreateProductTypeCommand(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtPrdctTpCMDFacade.newCrtPrdctTpCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateProductTypeCommand result = new CreateProductTypeCommand(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateProductTypeCommandProxi)PersistentProxi.createProxi(id, 152);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateProductTypeCommandProxi newDelayedCreateProductTypeCommand() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtPrdctTpCMDFacade.newDelayedCrtPrdctTpCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateProductTypeCommand result = new CreateProductTypeCommand(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateProductTypeCommandProxi)PersistentProxi.createProxi(id, 152);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateProductTypeCommand getCreateProductTypeCommand(long CreateProductTypeCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtPrdctTpCMDFacade.getCrtPrdctTpCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CreateProductTypeCommandId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            Invoker invoker = null;
            if (obj.getLong(2) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentTypeManager commandReceiver = null;
            if (obj.getLong(4) != 0)
                commandReceiver = (PersistentTypeManager)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentMAbstractProductType commandResult = null;
            if (obj.getLong(6) != 0)
                commandResult = (PersistentMAbstractProductType)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(8) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            CreateProductTypeCommand result = new CreateProductTypeCommand(invoker,
                                                                           commandReceiver,
                                                                           commandResult,
                                                                           myCommonDate,
                                                                           CreateProductTypeCommandId);
            obj.close();
            callable.close();
            CreateProductTypeCommandICProxi inCache = (CreateProductTypeCommandICProxi)Cache.getTheCache().put(result);
            CreateProductTypeCommand objectInCache = (CreateProductTypeCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtPrdctTpCMDFacade.getClass(?); end;");
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
    public long factorsAdd(long CreateProductTypeCommandId, PersistentMType factorsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtPrdctTpCMDFacade.fctrsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, CreateProductTypeCommandId);
            callable.setLong(3, factorsVal.getId());
            callable.setLong(4, factorsVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void factorsRem(long factorsId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtPrdctTpCMDFacade.fctrsRem(?); end;");
            callable.setLong(1, factorsId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public MTypeList factorsGet(long CreateProductTypeCommandId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtPrdctTpCMDFacade.fctrsGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CreateProductTypeCommandId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            MTypeList result = new MTypeList();
            while (list.next()) {
                result.add((PersistentMType)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long CreateProductTypeCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtPrdctTpCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, CreateProductTypeCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long CreateProductTypeCommandId, PersistentTypeManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtPrdctTpCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, CreateProductTypeCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandResultSet(long CreateProductTypeCommandId, PersistentMAbstractProductType commandResultVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtPrdctTpCMDFacade.cResultSet(?, ?, ?); end;");
            callable.setLong(1, CreateProductTypeCommandId);
            callable.setLong(2, commandResultVal.getId());
            callable.setLong(3, commandResultVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long CreateProductTypeCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtPrdctTpCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, CreateProductTypeCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

