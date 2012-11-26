package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class CreateAssociationCommandFacade{

	private String schemaName;
	private Connection con;

	public CreateAssociationCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CreateAssociationCommandProxi newCreateAssociationCommand(String name,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtAssctnCMDFacade.newCrtAssctnCMD(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateAssociationCommand result = new CreateAssociationCommand(name,null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateAssociationCommandProxi)PersistentProxi.createProxi(id, 146);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateAssociationCommandProxi newDelayedCreateAssociationCommand(String name) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtAssctnCMDFacade.newDelayedCrtAssctnCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateAssociationCommand result = new CreateAssociationCommand(name,null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateAssociationCommandProxi)PersistentProxi.createProxi(id, 146);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateAssociationCommand getCreateAssociationCommand(long CreateAssociationCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtAssctnCMDFacade.getCrtAssctnCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CreateAssociationCommandId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            MType source = null;
            if (obj.getLong(3) != 0)
                source = (MType)PersistentProxi.createProxi(obj.getLong(3), obj.getLong(4));
            MType target = null;
            if (obj.getLong(5) != 0)
                target = (MType)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            Invoker invoker = null;
            if (obj.getLong(7) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            PersistentAssociationManager commandReceiver = null;
            if (obj.getLong(9) != 0)
                commandReceiver = (PersistentAssociationManager)PersistentProxi.createProxi(obj.getLong(9), obj.getLong(10));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(11) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(11), obj.getLong(12));
            CreateAssociationCommand result = new CreateAssociationCommand(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                                                           source,
                                                                           target,
                                                                           invoker,
                                                                           commandReceiver,
                                                                           myCommonDate,
                                                                           CreateAssociationCommandId);
            obj.close();
            callable.close();
            CreateAssociationCommandICProxi inCache = (CreateAssociationCommandICProxi)Cache.getTheCache().put(result);
            CreateAssociationCommand objectInCache = (CreateAssociationCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtAssctnCMDFacade.getClass(?); end;");
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
    public void nameSet(long CreateAssociationCommandId, String nameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAssctnCMDFacade.nmSet(?, ?); end;");
            callable.setLong(1, CreateAssociationCommandId);
            callable.setString(2, nameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void sourceSet(long CreateAssociationCommandId, MType sourceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAssctnCMDFacade.srcSet(?, ?, ?); end;");
            callable.setLong(1, CreateAssociationCommandId);
            callable.setLong(2, sourceVal.getId());
            callable.setLong(3, sourceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void targetSet(long CreateAssociationCommandId, MType targetVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAssctnCMDFacade.trgtSet(?, ?, ?); end;");
            callable.setLong(1, CreateAssociationCommandId);
            callable.setLong(2, targetVal.getId());
            callable.setLong(3, targetVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long CreateAssociationCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAssctnCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, CreateAssociationCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long CreateAssociationCommandId, PersistentAssociationManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAssctnCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, CreateAssociationCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long CreateAssociationCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAssctnCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, CreateAssociationCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

