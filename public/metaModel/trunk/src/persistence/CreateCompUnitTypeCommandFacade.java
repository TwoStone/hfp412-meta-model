package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class CreateCompUnitTypeCommandFacade{

	private String schemaName;
	private Connection con;

	public CreateCompUnitTypeCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CreateCompUnitTypeCommandProxi newCreateCompUnitTypeCommand(String name,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtCmpUntTpCMDFacade.newCrtCmpUntTpCMD(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateCompUnitTypeCommand result = new CreateCompUnitTypeCommand(name,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateCompUnitTypeCommandProxi)PersistentProxi.createProxi(id, 163);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateCompUnitTypeCommandProxi newDelayedCreateCompUnitTypeCommand(String name) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtCmpUntTpCMDFacade.newDelayedCrtCmpUntTpCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateCompUnitTypeCommand result = new CreateCompUnitTypeCommand(name,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateCompUnitTypeCommandProxi)PersistentProxi.createProxi(id, 163);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateCompUnitTypeCommand getCreateCompUnitTypeCommand(long CreateCompUnitTypeCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtCmpUntTpCMDFacade.getCrtCmpUntTpCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CreateCompUnitTypeCommandId);
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
            CreateCompUnitTypeCommand result = new CreateCompUnitTypeCommand(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                                                             invoker,
                                                                             commandReceiver,
                                                                             myCommonDate,
                                                                             CreateCompUnitTypeCommandId);
            obj.close();
            callable.close();
            CreateCompUnitTypeCommandICProxi inCache = (CreateCompUnitTypeCommandICProxi)Cache.getTheCache().put(result);
            CreateCompUnitTypeCommand objectInCache = (CreateCompUnitTypeCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtCmpUntTpCMDFacade.getClass(?); end;");
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
    public void nameSet(long CreateCompUnitTypeCommandId, String nameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtCmpUntTpCMDFacade.nmSet(?, ?); end;");
            callable.setLong(1, CreateCompUnitTypeCommandId);
            callable.setString(2, nameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long CreateCompUnitTypeCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtCmpUntTpCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, CreateCompUnitTypeCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long CreateCompUnitTypeCommandId, PersistentUnitTypeManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtCmpUntTpCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, CreateCompUnitTypeCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long CreateCompUnitTypeCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtCmpUntTpCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, CreateCompUnitTypeCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

