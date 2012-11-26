package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class CreateAspectCommandFacade{

	private String schemaName;
	private Connection con;

	public CreateAspectCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CreateAspectCommandProxi newCreateAspectCommand(String name,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtAspctCMDFacade.newCrtAspctCMD(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateAspectCommand result = new CreateAspectCommand(name,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateAspectCommandProxi)PersistentProxi.createProxi(id, 139);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateAspectCommandProxi newDelayedCreateAspectCommand(String name) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtAspctCMDFacade.newDelayedCrtAspctCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateAspectCommand result = new CreateAspectCommand(name,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateAspectCommandProxi)PersistentProxi.createProxi(id, 139);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateAspectCommand getCreateAspectCommand(long CreateAspectCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtAspctCMDFacade.getCrtAspctCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CreateAspectCommandId);
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
            PersistentAspectManager commandReceiver = null;
            if (obj.getLong(5) != 0)
                commandReceiver = (PersistentAspectManager)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(7) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            CreateAspectCommand result = new CreateAspectCommand(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                                                 invoker,
                                                                 commandReceiver,
                                                                 myCommonDate,
                                                                 CreateAspectCommandId);
            obj.close();
            callable.close();
            CreateAspectCommandICProxi inCache = (CreateAspectCommandICProxi)Cache.getTheCache().put(result);
            CreateAspectCommand objectInCache = (CreateAspectCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtAspctCMDFacade.getClass(?); end;");
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
    public void nameSet(long CreateAspectCommandId, String nameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAspctCMDFacade.nmSet(?, ?); end;");
            callable.setLong(1, CreateAspectCommandId);
            callable.setString(2, nameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long CreateAspectCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAspctCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, CreateAspectCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long CreateAspectCommandId, PersistentAspectManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAspctCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, CreateAspectCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long CreateAspectCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAspctCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, CreateAspectCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

