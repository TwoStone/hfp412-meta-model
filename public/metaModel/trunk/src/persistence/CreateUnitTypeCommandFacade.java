package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class CreateUnitTypeCommandFacade{

	private String schemaName;
	private Connection con;

	public CreateUnitTypeCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CreateUnitTypeCommandProxi newCreateUnitTypeCommand(String name,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtUntTpCMDFacade.newCrtUntTpCMD(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateUnitTypeCommand result = new CreateUnitTypeCommand(name,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateUnitTypeCommandProxi)PersistentProxi.createProxi(id, 171);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateUnitTypeCommandProxi newDelayedCreateUnitTypeCommand(String name) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtUntTpCMDFacade.newDelayedCrtUntTpCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateUnitTypeCommand result = new CreateUnitTypeCommand(name,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateUnitTypeCommandProxi)PersistentProxi.createProxi(id, 171);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateUnitTypeCommand getCreateUnitTypeCommand(long CreateUnitTypeCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtUntTpCMDFacade.getCrtUntTpCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CreateUnitTypeCommandId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            Invoker invoker = null;
            if (obj.getLong(3) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(3), obj.getLong(4));
            PersistentUnitTypeManager commandReceiver = null;
            if (obj.getLong(5) != 0)
                commandReceiver = (PersistentUnitTypeManager)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(7) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            CreateUnitTypeCommand result = new CreateUnitTypeCommand(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                                                     invoker,
                                                                     commandReceiver,
                                                                     myCommonDate,
                                                                     CreateUnitTypeCommandId);
            obj.close();
            callable.close();
            CreateUnitTypeCommandICProxi inCache = (CreateUnitTypeCommandICProxi)Cache.getTheCache().put(result);
            CreateUnitTypeCommand objectInCache = (CreateUnitTypeCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtUntTpCMDFacade.getClass(?); end;");
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
    public void nameSet(long CreateUnitTypeCommandId, String nameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtUntTpCMDFacade.nmSet(?, ?); end;");
            callable.setLong(1, CreateUnitTypeCommandId);
            callable.setString(2, nameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long CreateUnitTypeCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtUntTpCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, CreateUnitTypeCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long CreateUnitTypeCommandId, PersistentUnitTypeManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtUntTpCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, CreateUnitTypeCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long CreateUnitTypeCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtUntTpCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, CreateUnitTypeCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

