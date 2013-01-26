package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class CreateAtomicRootTypeCommandFacade{

	private String schemaName;
	private Connection con;

	public CreateAtomicRootTypeCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CreateAtomicRootTypeCommandProxi newCreateAtomicRootTypeCommand(String name,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtAtmcRtTpCMDFacade.newCrtAtmcRtTpCMD(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateAtomicRootTypeCommand result = new CreateAtomicRootTypeCommand(null,name,null,null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateAtomicRootTypeCommandProxi)PersistentProxi.createProxi(id, 191);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateAtomicRootTypeCommandProxi newDelayedCreateAtomicRootTypeCommand(String name) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtAtmcRtTpCMDFacade.newDelayedCrtAtmcRtTpCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateAtomicRootTypeCommand result = new CreateAtomicRootTypeCommand(null,name,null,null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateAtomicRootTypeCommandProxi)PersistentProxi.createProxi(id, 191);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateAtomicRootTypeCommand getCreateAtomicRootTypeCommand(long CreateAtomicRootTypeCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtAtmcRtTpCMDFacade.getCrtAtmcRtTpCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CreateAtomicRootTypeCommandId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentMAspect aspect = null;
            if (obj.getLong(2) != 0)
                aspect = (PersistentMAspect)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
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
            CreateAtomicRootTypeCommand result = new CreateAtomicRootTypeCommand(aspect,
                                                                                 obj.getString(4) == null ? "" : obj.getString(4) /* In Oracle "" = null !!! */,
                                                                                 singletonType,
                                                                                 abstractType,
                                                                                 invoker,
                                                                                 commandReceiver,
                                                                                 commandResult,
                                                                                 myCommonDate,
                                                                                 CreateAtomicRootTypeCommandId);
            obj.close();
            callable.close();
            CreateAtomicRootTypeCommandICProxi inCache = (CreateAtomicRootTypeCommandICProxi)Cache.getTheCache().put(result);
            CreateAtomicRootTypeCommand objectInCache = (CreateAtomicRootTypeCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtAtmcRtTpCMDFacade.getClass(?); end;");
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
    public void aspectSet(long CreateAtomicRootTypeCommandId, PersistentMAspect aspectVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAtmcRtTpCMDFacade.aspctSet(?, ?, ?); end;");
            callable.setLong(1, CreateAtomicRootTypeCommandId);
            callable.setLong(2, aspectVal.getId());
            callable.setLong(3, aspectVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void nameSet(long CreateAtomicRootTypeCommandId, String nameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAtmcRtTpCMDFacade.nmSet(?, ?); end;");
            callable.setLong(1, CreateAtomicRootTypeCommandId);
            callable.setString(2, nameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void singletonTypeSet(long CreateAtomicRootTypeCommandId, PersistentMBoolean singletonTypeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAtmcRtTpCMDFacade.sngltnTpSet(?, ?, ?); end;");
            callable.setLong(1, CreateAtomicRootTypeCommandId);
            callable.setLong(2, singletonTypeVal.getId());
            callable.setLong(3, singletonTypeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void abstractTypeSet(long CreateAtomicRootTypeCommandId, PersistentMBoolean abstractTypeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAtmcRtTpCMDFacade.abstrctTpSet(?, ?, ?); end;");
            callable.setLong(1, CreateAtomicRootTypeCommandId);
            callable.setLong(2, abstractTypeVal.getId());
            callable.setLong(3, abstractTypeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long CreateAtomicRootTypeCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAtmcRtTpCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, CreateAtomicRootTypeCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long CreateAtomicRootTypeCommandId, PersistentTypeManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAtmcRtTpCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, CreateAtomicRootTypeCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandResultSet(long CreateAtomicRootTypeCommandId, PersistentMAtomicType commandResultVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAtmcRtTpCMDFacade.cResultSet(?, ?, ?); end;");
            callable.setLong(1, CreateAtomicRootTypeCommandId);
            callable.setLong(2, commandResultVal.getId());
            callable.setLong(3, commandResultVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long CreateAtomicRootTypeCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAtmcRtTpCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, CreateAtomicRootTypeCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

