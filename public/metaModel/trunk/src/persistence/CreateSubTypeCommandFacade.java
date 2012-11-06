package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class CreateSubTypeCommandFacade{

	private String schemaName;
	private Connection con;

	public CreateSubTypeCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CreateSubTypeCommandProxi newCreateSubTypeCommand(String name) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtSbTpCMDFacade.newCrtSbTpCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateSubTypeCommand result = new CreateSubTypeCommand(null,name,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateSubTypeCommandProxi)PersistentProxi.createProxi(id, 135);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateSubTypeCommand getCreateSubTypeCommand(long CreateSubTypeCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtSbTpCMDFacade.getCrtSbTpCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CreateSubTypeCommandId);
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
            Invoker invoker = null;
            if (obj.getLong(5) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            PersistentTypeManager commandReceiver = null;
            if (obj.getLong(7) != 0)
                commandReceiver = (PersistentTypeManager)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(9) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(9), obj.getLong(10));
            CreateSubTypeCommand result = new CreateSubTypeCommand(superType,
                                                                   obj.getString(4) == null ? "" : obj.getString(4) /* In Oracle "" = null !!! */,
                                                                   invoker,
                                                                   commandReceiver,
                                                                   myCommonDate,
                                                                   CreateSubTypeCommandId);
            obj.close();
            callable.close();
            CreateSubTypeCommandICProxi inCache = (CreateSubTypeCommandICProxi)Cache.getTheCache().put(result);
            CreateSubTypeCommand objectInCache = (CreateSubTypeCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtSbTpCMDFacade.getClass(?); end;");
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
    public void superTypeSet(long CreateSubTypeCommandId, PersistentMAtomicType superTypeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtSbTpCMDFacade.sprTpSet(?, ?, ?); end;");
            callable.setLong(1, CreateSubTypeCommandId);
            callable.setLong(2, superTypeVal.getId());
            callable.setLong(3, superTypeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void nameSet(long CreateSubTypeCommandId, String nameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtSbTpCMDFacade.nmSet(?, ?); end;");
            callable.setLong(1, CreateSubTypeCommandId);
            callable.setString(2, nameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long CreateSubTypeCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtSbTpCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, CreateSubTypeCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long CreateSubTypeCommandId, PersistentTypeManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtSbTpCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, CreateSubTypeCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long CreateSubTypeCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtSbTpCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, CreateSubTypeCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

