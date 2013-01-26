package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class RemoveFpCommandFacade{

	private String schemaName;
	private Connection con;

	public RemoveFpCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public RemoveFpCommandProxi newRemoveFpCommand(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvFpCMDFacade.newRmvFpCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            RemoveFpCommand result = new RemoveFpCommand(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (RemoveFpCommandProxi)PersistentProxi.createProxi(id, 133);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public RemoveFpCommandProxi newDelayedRemoveFpCommand() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvFpCMDFacade.newDelayedRmvFpCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            RemoveFpCommand result = new RemoveFpCommand(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (RemoveFpCommandProxi)PersistentProxi.createProxi(id, 133);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public RemoveFpCommand getRemoveFpCommand(long RemoveFpCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvFpCMDFacade.getRmvFpCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, RemoveFpCommandId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentFormalParameter fp = null;
            if (obj.getLong(2) != 0)
                fp = (PersistentFormalParameter)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            Invoker invoker = null;
            if (obj.getLong(4) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentOperationManager commandReceiver = null;
            if (obj.getLong(6) != 0)
                commandReceiver = (PersistentOperationManager)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(8) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            RemoveFpCommand result = new RemoveFpCommand(fp,
                                                         invoker,
                                                         commandReceiver,
                                                         myCommonDate,
                                                         RemoveFpCommandId);
            obj.close();
            callable.close();
            RemoveFpCommandICProxi inCache = (RemoveFpCommandICProxi)Cache.getTheCache().put(result);
            RemoveFpCommand objectInCache = (RemoveFpCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvFpCMDFacade.getClass(?); end;");
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
    public void fpSet(long RemoveFpCommandId, PersistentFormalParameter fpVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvFpCMDFacade.fpSet(?, ?, ?); end;");
            callable.setLong(1, RemoveFpCommandId);
            callable.setLong(2, fpVal.getId());
            callable.setLong(3, fpVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long RemoveFpCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvFpCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, RemoveFpCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long RemoveFpCommandId, PersistentOperationManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvFpCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, RemoveFpCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long RemoveFpCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvFpCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, RemoveFpCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

