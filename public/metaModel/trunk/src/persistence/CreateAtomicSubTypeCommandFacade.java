package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class CreateAtomicSubTypeCommandFacade{

	private String schemaName;
	private Connection con;

	public CreateAtomicSubTypeCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CreateAtomicSubTypeCommandProxi newCreateAtomicSubTypeCommand(String name,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtAtmcSbTpCMDFacade.newCrtAtmcSbTpCMD(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateAtomicSubTypeCommand result = new CreateAtomicSubTypeCommand(null,name,null,null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateAtomicSubTypeCommandProxi)PersistentProxi.createProxi(id, 157);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateAtomicSubTypeCommandProxi newDelayedCreateAtomicSubTypeCommand(String name) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtAtmcSbTpCMDFacade.newDelayedCrtAtmcSbTpCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateAtomicSubTypeCommand result = new CreateAtomicSubTypeCommand(null,name,null,null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateAtomicSubTypeCommandProxi)PersistentProxi.createProxi(id, 157);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateAtomicSubTypeCommand getCreateAtomicSubTypeCommand(long CreateAtomicSubTypeCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtAtmcSbTpCMDFacade.getCrtAtmcSbTpCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CreateAtomicSubTypeCommandId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentMAtomicType superType = null;
            if (obj.getLong(2) != 0)
                superType = (PersistentMAtomicType)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentMBoolean singletonType = null;
            if (obj.getLong(5) != 0)
                singletonType = (PersistentMBoolean)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            PersistentMBoolean abstractType = null;
            if (obj.getLong(7) != 0)
                abstractType = (PersistentMBoolean)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            Invoker invoker = null;
            if (obj.getLong(9) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(9), obj.getLong(10));
            PersistentTypeManager commandReceiver = null;
            if (obj.getLong(11) != 0)
                commandReceiver = (PersistentTypeManager)PersistentProxi.createProxi(obj.getLong(11), obj.getLong(12));
            PersistentMAtomicType commandResult = null;
            if (obj.getLong(13) != 0)
                commandResult = (PersistentMAtomicType)PersistentProxi.createProxi(obj.getLong(13), obj.getLong(14));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(15) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(15), obj.getLong(16));
            CreateAtomicSubTypeCommand result = new CreateAtomicSubTypeCommand(superType,
                                                                               obj.getString(4) == null ? "" : obj.getString(4) /* In Oracle "" = null !!! */,
                                                                               singletonType,
                                                                               abstractType,
                                                                               invoker,
                                                                               commandReceiver,
                                                                               commandResult,
                                                                               myCommonDate,
                                                                               CreateAtomicSubTypeCommandId);
            obj.close();
            callable.close();
            CreateAtomicSubTypeCommandICProxi inCache = (CreateAtomicSubTypeCommandICProxi)Cache.getTheCache().put(result);
            CreateAtomicSubTypeCommand objectInCache = (CreateAtomicSubTypeCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtAtmcSbTpCMDFacade.getClass(?); end;");
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
    public void superTypeSet(long CreateAtomicSubTypeCommandId, PersistentMAtomicType superTypeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAtmcSbTpCMDFacade.sprTpSet(?, ?, ?); end;");
            callable.setLong(1, CreateAtomicSubTypeCommandId);
            callable.setLong(2, superTypeVal.getId());
            callable.setLong(3, superTypeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void nameSet(long CreateAtomicSubTypeCommandId, String nameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAtmcSbTpCMDFacade.nmSet(?, ?); end;");
            callable.setLong(1, CreateAtomicSubTypeCommandId);
            callable.setString(2, nameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void singletonTypeSet(long CreateAtomicSubTypeCommandId, PersistentMBoolean singletonTypeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAtmcSbTpCMDFacade.sngltnTpSet(?, ?, ?); end;");
            callable.setLong(1, CreateAtomicSubTypeCommandId);
            callable.setLong(2, singletonTypeVal.getId());
            callable.setLong(3, singletonTypeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void abstractTypeSet(long CreateAtomicSubTypeCommandId, PersistentMBoolean abstractTypeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAtmcSbTpCMDFacade.abstrctTpSet(?, ?, ?); end;");
            callable.setLong(1, CreateAtomicSubTypeCommandId);
            callable.setLong(2, abstractTypeVal.getId());
            callable.setLong(3, abstractTypeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long CreateAtomicSubTypeCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAtmcSbTpCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, CreateAtomicSubTypeCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long CreateAtomicSubTypeCommandId, PersistentTypeManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAtmcSbTpCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, CreateAtomicSubTypeCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandResultSet(long CreateAtomicSubTypeCommandId, PersistentMAtomicType commandResultVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAtmcSbTpCMDFacade.cResultSet(?, ?, ?); end;");
            callable.setLong(1, CreateAtomicSubTypeCommandId);
            callable.setLong(2, commandResultVal.getId());
            callable.setLong(3, commandResultVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long CreateAtomicSubTypeCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAtmcSbTpCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, CreateAtomicSubTypeCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

