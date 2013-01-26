package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class CreateLinkCommandFacade{

	private String schemaName;
	private Connection con;

	public CreateLinkCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CreateLinkCommandProxi newCreateLinkCommand(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtLnkCMDFacade.newCrtLnkCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateLinkCommand result = new CreateLinkCommand(null,null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateLinkCommandProxi)PersistentProxi.createProxi(id, 160);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateLinkCommandProxi newDelayedCreateLinkCommand() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtLnkCMDFacade.newDelayedCrtLnkCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateLinkCommand result = new CreateLinkCommand(null,null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateLinkCommandProxi)PersistentProxi.createProxi(id, 160);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateLinkCommand getCreateLinkCommand(long CreateLinkCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtLnkCMDFacade.getCrtLnkCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CreateLinkCommandId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentAssociation type = null;
            if (obj.getLong(2) != 0)
                type = (PersistentAssociation)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentInstanceObject source = null;
            if (obj.getLong(4) != 0)
                source = (PersistentInstanceObject)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentInstanceObject target = null;
            if (obj.getLong(6) != 0)
                target = (PersistentInstanceObject)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            Invoker invoker = null;
            if (obj.getLong(8) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            PersistentLinkManager commandReceiver = null;
            if (obj.getLong(10) != 0)
                commandReceiver = (PersistentLinkManager)PersistentProxi.createProxi(obj.getLong(10), obj.getLong(11));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(12) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(12), obj.getLong(13));
            CreateLinkCommand result = new CreateLinkCommand(type,
                                                             source,
                                                             target,
                                                             invoker,
                                                             commandReceiver,
                                                             myCommonDate,
                                                             CreateLinkCommandId);
            obj.close();
            callable.close();
            CreateLinkCommandICProxi inCache = (CreateLinkCommandICProxi)Cache.getTheCache().put(result);
            CreateLinkCommand objectInCache = (CreateLinkCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtLnkCMDFacade.getClass(?); end;");
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
    public void typeSet(long CreateLinkCommandId, PersistentAssociation typeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtLnkCMDFacade.tpSet(?, ?, ?); end;");
            callable.setLong(1, CreateLinkCommandId);
            callable.setLong(2, typeVal.getId());
            callable.setLong(3, typeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void sourceSet(long CreateLinkCommandId, PersistentInstanceObject sourceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtLnkCMDFacade.srcSet(?, ?, ?); end;");
            callable.setLong(1, CreateLinkCommandId);
            callable.setLong(2, sourceVal.getId());
            callable.setLong(3, sourceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void targetSet(long CreateLinkCommandId, PersistentInstanceObject targetVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtLnkCMDFacade.trgtSet(?, ?, ?); end;");
            callable.setLong(1, CreateLinkCommandId);
            callable.setLong(2, targetVal.getId());
            callable.setLong(3, targetVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long CreateLinkCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtLnkCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, CreateLinkCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long CreateLinkCommandId, PersistentLinkManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtLnkCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, CreateLinkCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long CreateLinkCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtLnkCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, CreateLinkCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

