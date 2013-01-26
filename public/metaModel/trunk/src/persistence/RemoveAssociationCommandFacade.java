package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class RemoveAssociationCommandFacade{

	private String schemaName;
	private Connection con;

	public RemoveAssociationCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public RemoveAssociationCommandProxi newRemoveAssociationCommand(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvAssctnCMDFacade.newRmvAssctnCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            RemoveAssociationCommand result = new RemoveAssociationCommand(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (RemoveAssociationCommandProxi)PersistentProxi.createProxi(id, 164);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public RemoveAssociationCommandProxi newDelayedRemoveAssociationCommand() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvAssctnCMDFacade.newDelayedRmvAssctnCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            RemoveAssociationCommand result = new RemoveAssociationCommand(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (RemoveAssociationCommandProxi)PersistentProxi.createProxi(id, 164);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public RemoveAssociationCommand getRemoveAssociationCommand(long RemoveAssociationCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvAssctnCMDFacade.getRmvAssctnCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, RemoveAssociationCommandId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentAssociation a = null;
            if (obj.getLong(2) != 0)
                a = (PersistentAssociation)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            Invoker invoker = null;
            if (obj.getLong(4) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentAssociationManager commandReceiver = null;
            if (obj.getLong(6) != 0)
                commandReceiver = (PersistentAssociationManager)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(8) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            RemoveAssociationCommand result = new RemoveAssociationCommand(a,
                                                                           invoker,
                                                                           commandReceiver,
                                                                           myCommonDate,
                                                                           RemoveAssociationCommandId);
            obj.close();
            callable.close();
            RemoveAssociationCommandICProxi inCache = (RemoveAssociationCommandICProxi)Cache.getTheCache().put(result);
            RemoveAssociationCommand objectInCache = (RemoveAssociationCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvAssctnCMDFacade.getClass(?); end;");
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
    public void aSet(long RemoveAssociationCommandId, PersistentAssociation aVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvAssctnCMDFacade.aSet(?, ?, ?); end;");
            callable.setLong(1, RemoveAssociationCommandId);
            callable.setLong(2, aVal.getId());
            callable.setLong(3, aVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long RemoveAssociationCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvAssctnCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, RemoveAssociationCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long RemoveAssociationCommandId, PersistentAssociationManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvAssctnCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, RemoveAssociationCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long RemoveAssociationCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvAssctnCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, RemoveAssociationCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

