package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class AddFpCommandFacade{

	private String schemaName;
	private Connection con;

	public AddFpCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public AddFpCommandProxi newAddFpCommand(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AddFpCMDFacade.newAddFpCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AddFpCommand result = new AddFpCommand(null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (AddFpCommandProxi)PersistentProxi.createProxi(id, 167);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AddFpCommandProxi newDelayedAddFpCommand() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AddFpCMDFacade.newDelayedAddFpCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AddFpCommand result = new AddFpCommand(null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (AddFpCommandProxi)PersistentProxi.createProxi(id, 167);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AddFpCommand getAddFpCommand(long AddFpCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AddFpCMDFacade.getAddFpCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AddFpCommandId);
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
            AddFpCommand result = new AddFpCommand(op,
                                                   fp,
                                                   invoker,
                                                   commandReceiver,
                                                   myCommonDate,
                                                   AddFpCommandId);
            obj.close();
            callable.close();
            AddFpCommandICProxi inCache = (AddFpCommandICProxi)Cache.getTheCache().put(result);
            AddFpCommand objectInCache = (AddFpCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AddFpCMDFacade.getClass(?); end;");
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
    public void opSet(long AddFpCommandId, PersistentOperation opVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddFpCMDFacade.opSet(?, ?, ?); end;");
            callable.setLong(1, AddFpCommandId);
            callable.setLong(2, opVal.getId());
            callable.setLong(3, opVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void fpSet(long AddFpCommandId, PersistentFormalParameter fpVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddFpCMDFacade.fpSet(?, ?, ?); end;");
            callable.setLong(1, AddFpCommandId);
            callable.setLong(2, fpVal.getId());
            callable.setLong(3, fpVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long AddFpCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddFpCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, AddFpCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long AddFpCommandId, PersistentOperationManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddFpCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, AddFpCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long AddFpCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddFpCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, AddFpCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

