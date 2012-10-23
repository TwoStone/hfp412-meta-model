package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class MetaAssociationFacade{

	private String schemaName;
	private Connection con;

	public MetaAssociationFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public MetaAssociationProxi newMetaAssociation(String name) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MtAssctnFacade.newMtAssctn(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            MetaAssociation result = new MetaAssociation(name,null,null,null,id);
            Cache.getTheCache().put(result);
            return (MetaAssociationProxi)PersistentProxi.createProxi(id, 126);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MetaAssociation getMetaAssociation(long MetaAssociationId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MtAssctnFacade.getMtAssctn(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, MetaAssociationId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentNamedEntity This = null;
            if (obj.getLong(3) != 0)
                This = (PersistentNamedEntity)PersistentProxi.createProxi(obj.getLong(3), obj.getLong(4));
            PersistentAbstractMetaType source = null;
            if (obj.getLong(5) != 0)
                source = (PersistentAbstractMetaType)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            PersistentAbstractMetaType target = null;
            if (obj.getLong(7) != 0)
                target = (PersistentAbstractMetaType)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            MetaAssociation result = new MetaAssociation(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                                         This,
                                                         source,
                                                         target,
                                                         MetaAssociationId);
            obj.close();
            callable.close();
            MetaAssociationICProxi inCache = (MetaAssociationICProxi)Cache.getTheCache().put(result);
            MetaAssociation objectInCache = (MetaAssociation)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void sourceSet(long MetaAssociationId, PersistentAbstractMetaType sourceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MtAssctnFacade.srcSet(?, ?, ?); end;");
            callable.setLong(1, MetaAssociationId);
            callable.setLong(2, sourceVal.getId());
            callable.setLong(3, sourceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void targetSet(long MetaAssociationId, PersistentAbstractMetaType targetVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MtAssctnFacade.trgtSet(?, ?, ?); end;");
            callable.setLong(1, MetaAssociationId);
            callable.setLong(2, targetVal.getId());
            callable.setLong(3, targetVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long hierarchiesAdd(long MetaAssociationId, PersistentMetaHierarchy hierarchiesVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MtAssctnFacade.hrrchsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, MetaAssociationId);
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
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MtAssctnFacade.hrrchsRem(?); end;");
            callable.setLong(1, hierarchiesId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public MetaHierarchyList hierarchiesGet(long MetaAssociationId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MtAssctnFacade.hrrchsGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, MetaAssociationId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            MetaHierarchyList result = new MetaHierarchyList();
            while (list.next()) {
                result.add((PersistentMetaHierarchy)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public MetaAssociationSearchList inverseGetHierarchies(long objectId, long classId)throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MtAssctnFacade.iGetHrrchs(?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, objectId);
            callable.setLong(3, classId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            MetaAssociationSearchList result = new MetaAssociationSearchList();
            while (list.next()) {
                if (list.getLong(3) != 0) result.add((PersistentMetaAssociation)PersistentProxi.createProxi(list.getLong(3), list.getLong(4)));
                else result.add((PersistentMetaAssociation)PersistentProxi.createProxi(list.getLong(1), list.getLong(2)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

