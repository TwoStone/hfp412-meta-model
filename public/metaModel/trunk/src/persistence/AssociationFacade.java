package persistence;

import model.abstractOperation.*;

import java.sql.*;
import oracle.jdbc.*;

public class AssociationFacade{

	private String schemaName;
	private Connection con;

	public AssociationFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public AssociationProxi newAssociation(String name,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AssctnFacade.newAssctn(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Association result = new Association(name,null,null,null,id);
            Cache.getTheCache().put(result);
            return (AssociationProxi)PersistentProxi.createProxi(id, 117);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AssociationProxi newDelayedAssociation(String name) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AssctnFacade.newDelayedAssctn(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Association result = new Association(name,null,null,null,id);
            Cache.getTheCache().put(result);
            return (AssociationProxi)PersistentProxi.createProxi(id, 117);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Association getAssociation(long AssociationId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AssctnFacade.getAssctn(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AssociationId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentMType source = null;
            if (obj.getLong(3) != 0)
                source = (PersistentMType)PersistentProxi.createProxi(obj.getLong(3), obj.getLong(4));
            PersistentMType target = null;
            if (obj.getLong(5) != 0)
                target = (PersistentMType)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            PersistentAbsOperation This = null;
            if (obj.getLong(7) != 0)
                This = (PersistentAbsOperation)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            Association result = new Association(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                                 source,
                                                 target,
                                                 This,
                                                 AssociationId);
            obj.close();
            callable.close();
            AssociationICProxi inCache = (AssociationICProxi)Cache.getTheCache().put(result);
            Association objectInCache = (Association)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long hierarchiesAdd(long AssociationId, PersistentHierarchy hierarchiesVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AssctnFacade.hrrchsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, AssociationId);
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
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AssctnFacade.hrrchsRem(?); end;");
            callable.setLong(1, hierarchiesId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public HierarchyList hierarchiesGet(long AssociationId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AssctnFacade.hrrchsGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AssociationId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            HierarchyList result = new HierarchyList();
            while (list.next()) {
                result.add((PersistentHierarchy)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public AssociationSearchList inverseGetHierarchies(long objectId, long classId)throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AssctnFacade.iGetHrrchs(?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, objectId);
            callable.setLong(3, classId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            AssociationSearchList result = new AssociationSearchList();
            while (list.next()) {
                if (list.getLong(3) != 0) result.add((PersistentAssociation)PersistentProxi.createProxi(list.getLong(3), list.getLong(4)));
                else result.add((PersistentAssociation)PersistentProxi.createProxi(list.getLong(1), list.getLong(2)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

