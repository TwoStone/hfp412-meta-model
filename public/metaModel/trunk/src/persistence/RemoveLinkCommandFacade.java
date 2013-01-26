package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class RemoveLinkCommandFacade{

	private String schemaName;
	private Connection con;

	public RemoveLinkCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public RemoveLinkCommandProxi newRemoveLinkCommand(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvLnkCMDFacade.newRmvLnkCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            RemoveLinkCommand result = new RemoveLinkCommand(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (RemoveLinkCommandProxi)PersistentProxi.createProxi(id, 118);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public RemoveLinkCommandProxi newDelayedRemoveLinkCommand() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvLnkCMDFacade.newDelayedRmvLnkCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            RemoveLinkCommand result = new RemoveLinkCommand(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (RemoveLinkCommandProxi)PersistentProxi.createProxi(id, 118);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public RemoveLinkCommand getRemoveLinkCommand(long RemoveLinkCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvLnkCMDFacade.getRmvLnkCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, RemoveLinkCommandId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentLink link = null;
            if (obj.getLong(2) != 0)
                link = (PersistentLink)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            Invoker invoker = null;
            if (obj.getLong(4) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentLinkManager commandReceiver = null;
            if (obj.getLong(6) != 0)
                commandReceiver = (PersistentLinkManager)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(8) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            RemoveLinkCommand result = new RemoveLinkCommand(link,
                                                             invoker,
                                                             commandReceiver,
                                                             myCommonDate,
                                                             RemoveLinkCommandId);
            obj.close();
            callable.close();
            RemoveLinkCommandICProxi inCache = (RemoveLinkCommandICProxi)Cache.getTheCache().put(result);
            RemoveLinkCommand objectInCache = (RemoveLinkCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvLnkCMDFacade.getClass(?); end;");
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
    public void linkSet(long RemoveLinkCommandId, PersistentLink linkVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvLnkCMDFacade.lnkSet(?, ?, ?); end;");
            callable.setLong(1, RemoveLinkCommandId);
            callable.setLong(2, linkVal.getId());
            callable.setLong(3, linkVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long RemoveLinkCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvLnkCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, RemoveLinkCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long RemoveLinkCommandId, PersistentLinkManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvLnkCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, RemoveLinkCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long RemoveLinkCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvLnkCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, RemoveLinkCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

