package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class AssociationManagerFacade{

	private String schemaName;
	private Connection con;

	public AssociationManagerFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public AssociationManagerProxi getTheAssociationManager() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AssctnMngrFacade.getTheAssctnMngr; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (AssociationManagerProxi)PersistentProxi.createProxi(id, 141);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AssociationManager getAssociationManager(long AssociationManagerId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AssctnMngrFacade.getAssctnMngr(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AssociationManagerId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentAssociationManager This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentAssociationManager)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            AssociationManager result = new AssociationManager(This,
                                                               AssociationManagerId);
            obj.close();
            callable.close();
            AssociationManagerICProxi inCache = (AssociationManagerICProxi)Cache.getTheCache().put(result);
            AssociationManager objectInCache = (AssociationManager)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AssctnMngrFacade.getClass(?); end;");
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
    public long associationsAdd(long AssociationManagerId, PersistentMAssociation associationsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AssctnMngrFacade.assctnsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, AssociationManagerId);
            callable.setLong(3, associationsVal.getId());
            callable.setLong(4, associationsVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void associationsRem(long associationsId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AssctnMngrFacade.assctnsRem(?); end;");
            callable.setLong(1, associationsId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public MAssociationList associationsGet(long AssociationManagerId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AssctnMngrFacade.assctnsGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AssociationManagerId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            MAssociationList result = new MAssociationList();
            while (list.next()) {
                result.add((PersistentMAssociation)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long hierarchiesAdd(long AssociationManagerId, PersistentMAHierarchy hierarchiesVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AssctnMngrFacade.hrrchsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, AssociationManagerId);
            callable.setLong(3, hierarchiesVal.getId());
            callable.setLong(4, hierarchiesVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void hierarchiesRem(long hierarchiesId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AssctnMngrFacade.hrrchsRem(?); end;");
            callable.setLong(1, hierarchiesId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public MAHierarchyList hierarchiesGet(long AssociationManagerId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AssctnMngrFacade.hrrchsGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AssociationManagerId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            MAHierarchyList result = new MAHierarchyList();
            while (list.next()) {
                result.add((PersistentMAHierarchy)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long AssociationManagerId, PersistentAssociationManager ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AssctnMngrFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, AssociationManagerId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

