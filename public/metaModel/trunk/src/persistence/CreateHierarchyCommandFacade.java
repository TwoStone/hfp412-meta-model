package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class CreateHierarchyCommandFacade{

	private String schemaName;
	private Connection con;

	public CreateHierarchyCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CreateHierarchyCommandProxi newCreateHierarchyCommand(String name,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtHrrchCMDFacade.newCrtHrrchCMD(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateHierarchyCommand result = new CreateHierarchyCommand(name,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateHierarchyCommandProxi)PersistentProxi.createProxi(id, 144);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateHierarchyCommandProxi newDelayedCreateHierarchyCommand(String name) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtHrrchCMDFacade.newDelayedCrtHrrchCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateHierarchyCommand result = new CreateHierarchyCommand(name,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateHierarchyCommandProxi)PersistentProxi.createProxi(id, 144);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateHierarchyCommand getCreateHierarchyCommand(long CreateHierarchyCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtHrrchCMDFacade.getCrtHrrchCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CreateHierarchyCommandId);
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
            PersistentAssociationManager commandReceiver = null;
            if (obj.getLong(5) != 0)
                commandReceiver = (PersistentAssociationManager)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(7) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            CreateHierarchyCommand result = new CreateHierarchyCommand(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                                                       invoker,
                                                                       commandReceiver,
                                                                       myCommonDate,
                                                                       CreateHierarchyCommandId);
            obj.close();
            callable.close();
            CreateHierarchyCommandICProxi inCache = (CreateHierarchyCommandICProxi)Cache.getTheCache().put(result);
            CreateHierarchyCommand objectInCache = (CreateHierarchyCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtHrrchCMDFacade.getClass(?); end;");
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
    public void nameSet(long CreateHierarchyCommandId, String nameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtHrrchCMDFacade.nmSet(?, ?); end;");
            callable.setLong(1, CreateHierarchyCommandId);
            callable.setString(2, nameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long CreateHierarchyCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtHrrchCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, CreateHierarchyCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long CreateHierarchyCommandId, PersistentAssociationManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtHrrchCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, CreateHierarchyCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long CreateHierarchyCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtHrrchCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, CreateHierarchyCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

