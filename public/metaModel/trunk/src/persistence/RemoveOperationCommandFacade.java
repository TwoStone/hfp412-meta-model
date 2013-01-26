package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class RemoveOperationCommandFacade{

	private String schemaName;
	private Connection con;

	public RemoveOperationCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public RemoveOperationCommandProxi newRemoveOperationCommand(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvOprtnCMDFacade.newRmvOprtnCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            RemoveOperationCommand result = new RemoveOperationCommand(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (RemoveOperationCommandProxi)PersistentProxi.createProxi(id, 139);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public RemoveOperationCommandProxi newDelayedRemoveOperationCommand() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvOprtnCMDFacade.newDelayedRmvOprtnCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            RemoveOperationCommand result = new RemoveOperationCommand(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (RemoveOperationCommandProxi)PersistentProxi.createProxi(id, 139);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public RemoveOperationCommand getRemoveOperationCommand(long RemoveOperationCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvOprtnCMDFacade.getRmvOprtnCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, RemoveOperationCommandId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentOperation op = null;
            if (obj.getLong(2) != 0)
                op = (PersistentOperation)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            Invoker invoker = null;
            if (obj.getLong(4) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentOperationManager commandReceiver = null;
            if (obj.getLong(6) != 0)
                commandReceiver = (PersistentOperationManager)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(8) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            RemoveOperationCommand result = new RemoveOperationCommand(op,
                                                                       invoker,
                                                                       commandReceiver,
                                                                       myCommonDate,
                                                                       RemoveOperationCommandId);
            obj.close();
            callable.close();
            RemoveOperationCommandICProxi inCache = (RemoveOperationCommandICProxi)Cache.getTheCache().put(result);
            RemoveOperationCommand objectInCache = (RemoveOperationCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvOprtnCMDFacade.getClass(?); end;");
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
    public void opSet(long RemoveOperationCommandId, PersistentOperation opVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvOprtnCMDFacade.opSet(?, ?, ?); end;");
            callable.setLong(1, RemoveOperationCommandId);
            callable.setLong(2, opVal.getId());
            callable.setLong(3, opVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long RemoveOperationCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvOprtnCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, RemoveOperationCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long RemoveOperationCommandId, PersistentOperationManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvOprtnCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, RemoveOperationCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long RemoveOperationCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvOprtnCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, RemoveOperationCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

