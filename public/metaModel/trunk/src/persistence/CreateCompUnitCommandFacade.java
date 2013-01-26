package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class CreateCompUnitCommandFacade{

	private String schemaName;
	private Connection con;

	public CreateCompUnitCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CreateCompUnitCommandProxi newCreateCompUnitCommand(String name,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtCmpUntCMDFacade.newCrtCmpUntCMD(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateCompUnitCommand result = new CreateCompUnitCommand(name,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateCompUnitCommandProxi)PersistentProxi.createProxi(id, 161);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateCompUnitCommandProxi newDelayedCreateCompUnitCommand(String name) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtCmpUntCMDFacade.newDelayedCrtCmpUntCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateCompUnitCommand result = new CreateCompUnitCommand(name,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateCompUnitCommandProxi)PersistentProxi.createProxi(id, 161);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateCompUnitCommand getCreateCompUnitCommand(long CreateCompUnitCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtCmpUntCMDFacade.getCrtCmpUntCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CreateCompUnitCommandId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentCompUnitType type = null;
            if (obj.getLong(3) != 0)
                type = (PersistentCompUnitType)PersistentProxi.createProxi(obj.getLong(3), obj.getLong(4));
            Invoker invoker = null;
            if (obj.getLong(5) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            PersistentUnitTypeManager commandReceiver = null;
            if (obj.getLong(7) != 0)
                commandReceiver = (PersistentUnitTypeManager)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(9) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(9), obj.getLong(10));
            CreateCompUnitCommand result = new CreateCompUnitCommand(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                                                     type,
                                                                     invoker,
                                                                     commandReceiver,
                                                                     myCommonDate,
                                                                     CreateCompUnitCommandId);
            obj.close();
            callable.close();
            CreateCompUnitCommandICProxi inCache = (CreateCompUnitCommandICProxi)Cache.getTheCache().put(result);
            CreateCompUnitCommand objectInCache = (CreateCompUnitCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtCmpUntCMDFacade.getClass(?); end;");
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
    public void nameSet(long CreateCompUnitCommandId, String nameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtCmpUntCMDFacade.nmSet(?, ?); end;");
            callable.setLong(1, CreateCompUnitCommandId);
            callable.setString(2, nameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void typeSet(long CreateCompUnitCommandId, PersistentCompUnitType typeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtCmpUntCMDFacade.tpSet(?, ?, ?); end;");
            callable.setLong(1, CreateCompUnitCommandId);
            callable.setLong(2, typeVal.getId());
            callable.setLong(3, typeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long CreateCompUnitCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtCmpUntCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, CreateCompUnitCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long CreateCompUnitCommandId, PersistentUnitTypeManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtCmpUntCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, CreateCompUnitCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long CreateCompUnitCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtCmpUntCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, CreateCompUnitCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

