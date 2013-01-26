package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class RemoveMessageCommandFacade{

	private String schemaName;
	private Connection con;

	public RemoveMessageCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public RemoveMessageCommandProxi newRemoveMessageCommand(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvMssgCMDFacade.newRmvMssgCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            RemoveMessageCommand result = new RemoveMessageCommand(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (RemoveMessageCommandProxi)PersistentProxi.createProxi(id, 199);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public RemoveMessageCommandProxi newDelayedRemoveMessageCommand() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvMssgCMDFacade.newDelayedRmvMssgCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            RemoveMessageCommand result = new RemoveMessageCommand(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (RemoveMessageCommandProxi)PersistentProxi.createProxi(id, 199);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public RemoveMessageCommand getRemoveMessageCommand(long RemoveMessageCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvMssgCMDFacade.getRmvMssgCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, RemoveMessageCommandId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentMessage m = null;
            if (obj.getLong(2) != 0)
                m = (PersistentMessage)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            Invoker invoker = null;
            if (obj.getLong(4) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentMessageManager commandReceiver = null;
            if (obj.getLong(6) != 0)
                commandReceiver = (PersistentMessageManager)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(8) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            RemoveMessageCommand result = new RemoveMessageCommand(m,
                                                                   invoker,
                                                                   commandReceiver,
                                                                   myCommonDate,
                                                                   RemoveMessageCommandId);
            obj.close();
            callable.close();
            RemoveMessageCommandICProxi inCache = (RemoveMessageCommandICProxi)Cache.getTheCache().put(result);
            RemoveMessageCommand objectInCache = (RemoveMessageCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvMssgCMDFacade.getClass(?); end;");
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
    public void mSet(long RemoveMessageCommandId, PersistentMessage mVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvMssgCMDFacade.mSet(?, ?, ?); end;");
            callable.setLong(1, RemoveMessageCommandId);
            callable.setLong(2, mVal.getId());
            callable.setLong(3, mVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long RemoveMessageCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvMssgCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, RemoveMessageCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long RemoveMessageCommandId, PersistentMessageManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvMssgCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, RemoveMessageCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long RemoveMessageCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvMssgCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, RemoveMessageCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

