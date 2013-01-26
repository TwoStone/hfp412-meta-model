package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class RemoveAssoFrmHierCommandFacade{

	private String schemaName;
	private Connection con;

	public RemoveAssoFrmHierCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public RemoveAssoFrmHierCommandProxi newRemoveAssoFrmHierCommand(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvAssFrmHrCMDFacade.newRmvAssFrmHrCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            RemoveAssoFrmHierCommand result = new RemoveAssoFrmHierCommand(null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (RemoveAssoFrmHierCommandProxi)PersistentProxi.createProxi(id, 111);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public RemoveAssoFrmHierCommandProxi newDelayedRemoveAssoFrmHierCommand() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvAssFrmHrCMDFacade.newDelayedRmvAssFrmHrCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            RemoveAssoFrmHierCommand result = new RemoveAssoFrmHierCommand(null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (RemoveAssoFrmHierCommandProxi)PersistentProxi.createProxi(id, 111);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public RemoveAssoFrmHierCommand getRemoveAssoFrmHierCommand(long RemoveAssoFrmHierCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvAssFrmHrCMDFacade.getRmvAssFrmHrCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, RemoveAssoFrmHierCommandId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentHierarchy h = null;
            if (obj.getLong(2) != 0)
                h = (PersistentHierarchy)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentAssociation a = null;
            if (obj.getLong(4) != 0)
                a = (PersistentAssociation)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            Invoker invoker = null;
            if (obj.getLong(6) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentAssociationManager commandReceiver = null;
            if (obj.getLong(8) != 0)
                commandReceiver = (PersistentAssociationManager)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(10) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(10), obj.getLong(11));
            RemoveAssoFrmHierCommand result = new RemoveAssoFrmHierCommand(h,
                                                                           a,
                                                                           invoker,
                                                                           commandReceiver,
                                                                           myCommonDate,
                                                                           RemoveAssoFrmHierCommandId);
            obj.close();
            callable.close();
            RemoveAssoFrmHierCommandICProxi inCache = (RemoveAssoFrmHierCommandICProxi)Cache.getTheCache().put(result);
            RemoveAssoFrmHierCommand objectInCache = (RemoveAssoFrmHierCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvAssFrmHrCMDFacade.getClass(?); end;");
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
    public void hSet(long RemoveAssoFrmHierCommandId, PersistentHierarchy hVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvAssFrmHrCMDFacade.hSet(?, ?, ?); end;");
            callable.setLong(1, RemoveAssoFrmHierCommandId);
            callable.setLong(2, hVal.getId());
            callable.setLong(3, hVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void aSet(long RemoveAssoFrmHierCommandId, PersistentAssociation aVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvAssFrmHrCMDFacade.aSet(?, ?, ?); end;");
            callable.setLong(1, RemoveAssoFrmHierCommandId);
            callable.setLong(2, aVal.getId());
            callable.setLong(3, aVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long RemoveAssoFrmHierCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvAssFrmHrCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, RemoveAssoFrmHierCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long RemoveAssoFrmHierCommandId, PersistentAssociationManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvAssFrmHrCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, RemoveAssoFrmHierCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long RemoveAssoFrmHierCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvAssFrmHrCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, RemoveAssoFrmHierCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

