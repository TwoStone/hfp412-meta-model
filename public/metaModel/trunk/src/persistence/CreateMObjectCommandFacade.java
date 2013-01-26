package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class CreateMObjectCommandFacade{

	private String schemaName;
	private Connection con;

	public CreateMObjectCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CreateMObjectCommandProxi newCreateMObjectCommand(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtMObjctCMDFacade.newCrtMObjctCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateMObjectCommand result = new CreateMObjectCommand(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateMObjectCommandProxi)PersistentProxi.createProxi(id, 101);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateMObjectCommandProxi newDelayedCreateMObjectCommand() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtMObjctCMDFacade.newDelayedCrtMObjctCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateMObjectCommand result = new CreateMObjectCommand(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateMObjectCommandProxi)PersistentProxi.createProxi(id, 101);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateMObjectCommand getCreateMObjectCommand(long CreateMObjectCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtMObjctCMDFacade.getCrtMObjctCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CreateMObjectCommandId);
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
            PersistentObjectManager commandReceiver = null;
            if (obj.getLong(4) != 0)
                commandReceiver = (PersistentObjectManager)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentMObject commandResult = null;
            if (obj.getLong(6) != 0)
                commandResult = (PersistentMObject)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(8) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            CreateMObjectCommand result = new CreateMObjectCommand(invoker,
                                                                   commandReceiver,
                                                                   commandResult,
                                                                   myCommonDate,
                                                                   CreateMObjectCommandId);
            obj.close();
            callable.close();
            CreateMObjectCommandICProxi inCache = (CreateMObjectCommandICProxi)Cache.getTheCache().put(result);
            CreateMObjectCommand objectInCache = (CreateMObjectCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtMObjctCMDFacade.getClass(?); end;");
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
    public long typesAdd(long CreateMObjectCommandId, PersistentMAtomicType typesVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtMObjctCMDFacade.tpsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, CreateMObjectCommandId);
            callable.setLong(3, typesVal.getId());
            callable.setLong(4, typesVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void typesRem(long typesId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtMObjctCMDFacade.tpsRem(?); end;");
            callable.setLong(1, typesId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public MAtomicTypeList typesGet(long CreateMObjectCommandId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtMObjctCMDFacade.tpsGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CreateMObjectCommandId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            MAtomicTypeList result = new MAtomicTypeList();
            while (list.next()) {
                result.add((PersistentMAtomicType)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long CreateMObjectCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtMObjctCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, CreateMObjectCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long CreateMObjectCommandId, PersistentObjectManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtMObjctCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, CreateMObjectCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandResultSet(long CreateMObjectCommandId, PersistentMObject commandResultVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtMObjctCMDFacade.cResultSet(?, ?, ?); end;");
            callable.setLong(1, CreateMObjectCommandId);
            callable.setLong(2, commandResultVal.getId());
            callable.setLong(3, commandResultVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long CreateMObjectCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtMObjctCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, CreateMObjectCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

