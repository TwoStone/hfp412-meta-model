package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class RemoveFpFromOpCommandFacade{

	private String schemaName;
	private Connection con;

	public RemoveFpFromOpCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public RemoveFpFromOpCommandProxi newRemoveFpFromOpCommand(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvFpFrmOpCMDFacade.newRmvFpFrmOpCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            RemoveFpFromOpCommand result = new RemoveFpFromOpCommand(null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (RemoveFpFromOpCommandProxi)PersistentProxi.createProxi(id, 198);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public RemoveFpFromOpCommandProxi newDelayedRemoveFpFromOpCommand() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvFpFrmOpCMDFacade.newDelayedRmvFpFrmOpCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            RemoveFpFromOpCommand result = new RemoveFpFromOpCommand(null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (RemoveFpFromOpCommandProxi)PersistentProxi.createProxi(id, 198);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public RemoveFpFromOpCommand getRemoveFpFromOpCommand(long RemoveFpFromOpCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvFpFrmOpCMDFacade.getRmvFpFrmOpCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, RemoveFpFromOpCommandId);
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
            PersistentFormalParameter fp = null;
            if (obj.getLong(4) != 0)
                fp = (PersistentFormalParameter)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            Invoker invoker = null;
            if (obj.getLong(6) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentOperationManager commandReceiver = null;
            if (obj.getLong(8) != 0)
                commandReceiver = (PersistentOperationManager)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(10) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(10), obj.getLong(11));
            RemoveFpFromOpCommand result = new RemoveFpFromOpCommand(op,
                                                                     fp,
                                                                     invoker,
                                                                     commandReceiver,
                                                                     myCommonDate,
                                                                     RemoveFpFromOpCommandId);
            obj.close();
            callable.close();
            RemoveFpFromOpCommandICProxi inCache = (RemoveFpFromOpCommandICProxi)Cache.getTheCache().put(result);
            RemoveFpFromOpCommand objectInCache = (RemoveFpFromOpCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvFpFrmOpCMDFacade.getClass(?); end;");
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
    public void opSet(long RemoveFpFromOpCommandId, PersistentOperation opVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvFpFrmOpCMDFacade.opSet(?, ?, ?); end;");
            callable.setLong(1, RemoveFpFromOpCommandId);
            callable.setLong(2, opVal.getId());
            callable.setLong(3, opVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void fpSet(long RemoveFpFromOpCommandId, PersistentFormalParameter fpVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvFpFrmOpCMDFacade.fpSet(?, ?, ?); end;");
            callable.setLong(1, RemoveFpFromOpCommandId);
            callable.setLong(2, fpVal.getId());
            callable.setLong(3, fpVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long RemoveFpFromOpCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvFpFrmOpCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, RemoveFpFromOpCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long RemoveFpFromOpCommandId, PersistentOperationManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvFpFrmOpCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, RemoveFpFromOpCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long RemoveFpFromOpCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvFpFrmOpCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, RemoveFpFromOpCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

