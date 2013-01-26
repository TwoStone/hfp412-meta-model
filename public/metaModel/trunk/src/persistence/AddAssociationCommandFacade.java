package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class AddAssociationCommandFacade{

	private String schemaName;
	private Connection con;

	public AddAssociationCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public AddAssociationCommandProxi newAddAssociationCommand(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AddAssctnCMDFacade.newAddAssctnCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AddAssociationCommand result = new AddAssociationCommand(null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (AddAssociationCommandProxi)PersistentProxi.createProxi(id, 175);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AddAssociationCommandProxi newDelayedAddAssociationCommand() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AddAssctnCMDFacade.newDelayedAddAssctnCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AddAssociationCommand result = new AddAssociationCommand(null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (AddAssociationCommandProxi)PersistentProxi.createProxi(id, 175);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AddAssociationCommand getAddAssociationCommand(long AddAssociationCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AddAssctnCMDFacade.getAddAssctnCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AddAssociationCommandId);
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
            AddAssociationCommand result = new AddAssociationCommand(h,
                                                                     a,
                                                                     invoker,
                                                                     commandReceiver,
                                                                     myCommonDate,
                                                                     AddAssociationCommandId);
            obj.close();
            callable.close();
            AddAssociationCommandICProxi inCache = (AddAssociationCommandICProxi)Cache.getTheCache().put(result);
            AddAssociationCommand objectInCache = (AddAssociationCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AddAssctnCMDFacade.getClass(?); end;");
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
    public void hSet(long AddAssociationCommandId, PersistentHierarchy hVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddAssctnCMDFacade.hSet(?, ?, ?); end;");
            callable.setLong(1, AddAssociationCommandId);
            callable.setLong(2, hVal.getId());
            callable.setLong(3, hVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void aSet(long AddAssociationCommandId, PersistentAssociation aVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddAssctnCMDFacade.aSet(?, ?, ?); end;");
            callable.setLong(1, AddAssociationCommandId);
            callable.setLong(2, aVal.getId());
            callable.setLong(3, aVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long AddAssociationCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddAssctnCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, AddAssociationCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long AddAssociationCommandId, PersistentAssociationManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddAssctnCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, AddAssociationCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long AddAssociationCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddAssctnCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, AddAssociationCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

