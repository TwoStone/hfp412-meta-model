package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class AddToHierarchyCommandFacade{

	private String schemaName;
	private Connection con;

	public AddToHierarchyCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public AddToHierarchyCommandProxi newAddToHierarchyCommand(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AddTHrrchCMDFacade.newAddTHrrchCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AddToHierarchyCommand result = new AddToHierarchyCommand(null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (AddToHierarchyCommandProxi)PersistentProxi.createProxi(id, 145);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AddToHierarchyCommandProxi newDelayedAddToHierarchyCommand() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AddTHrrchCMDFacade.newDelayedAddTHrrchCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AddToHierarchyCommand result = new AddToHierarchyCommand(null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (AddToHierarchyCommandProxi)PersistentProxi.createProxi(id, 145);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AddToHierarchyCommand getAddToHierarchyCommand(long AddToHierarchyCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AddTHrrchCMDFacade.getAddTHrrchCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AddToHierarchyCommandId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentMAssociation association = null;
            if (obj.getLong(2) != 0)
                association = (PersistentMAssociation)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentMAHierarchy theHierarchy = null;
            if (obj.getLong(4) != 0)
                theHierarchy = (PersistentMAHierarchy)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            Invoker invoker = null;
            if (obj.getLong(6) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentAssociationManager commandReceiver = null;
            if (obj.getLong(8) != 0)
                commandReceiver = (PersistentAssociationManager)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(10) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(10), obj.getLong(11));
            AddToHierarchyCommand result = new AddToHierarchyCommand(association,
                                                                     theHierarchy,
                                                                     invoker,
                                                                     commandReceiver,
                                                                     myCommonDate,
                                                                     AddToHierarchyCommandId);
            obj.close();
            callable.close();
            AddToHierarchyCommandICProxi inCache = (AddToHierarchyCommandICProxi)Cache.getTheCache().put(result);
            AddToHierarchyCommand objectInCache = (AddToHierarchyCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AddTHrrchCMDFacade.getClass(?); end;");
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
    public void associationSet(long AddToHierarchyCommandId, PersistentMAssociation associationVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddTHrrchCMDFacade.assctnSet(?, ?, ?); end;");
            callable.setLong(1, AddToHierarchyCommandId);
            callable.setLong(2, associationVal.getId());
            callable.setLong(3, associationVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void theHierarchySet(long AddToHierarchyCommandId, PersistentMAHierarchy theHierarchyVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddTHrrchCMDFacade.thHrrchSet(?, ?, ?); end;");
            callable.setLong(1, AddToHierarchyCommandId);
            callable.setLong(2, theHierarchyVal.getId());
            callable.setLong(3, theHierarchyVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long AddToHierarchyCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddTHrrchCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, AddToHierarchyCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long AddToHierarchyCommandId, PersistentAssociationManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddTHrrchCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, AddToHierarchyCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long AddToHierarchyCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddTHrrchCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, AddToHierarchyCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

