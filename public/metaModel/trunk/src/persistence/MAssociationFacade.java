package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class MAssociationFacade{

	private String schemaName;
	private Connection con;

	public MAssociationFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public MAssociationProxi newMAssociation(String name,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MAssctnFacade.newMAssctn(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            MAssociation result = new MAssociation(name,null,null,null,id);
            Cache.getTheCache().put(result);
            return (MAssociationProxi)PersistentProxi.createProxi(id, 143);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MAssociationProxi newDelayedMAssociation(String name) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MAssctnFacade.newDelayedMAssctn(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            MAssociation result = new MAssociation(name,null,null,null,id);
            Cache.getTheCache().put(result);
            return (MAssociationProxi)PersistentProxi.createProxi(id, 143);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MAssociation getMAssociation(long MAssociationId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MAssctnFacade.getMAssctn(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, MAssociationId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            MType source = null;
            if (obj.getLong(3) != 0)
                source = (MType)PersistentProxi.createProxi(obj.getLong(3), obj.getLong(4));
            MType target = null;
            if (obj.getLong(5) != 0)
                target = (MType)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            PersistentMAssociation This = null;
            if (obj.getLong(7) != 0)
                This = (PersistentMAssociation)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            MAssociation result = new MAssociation(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                                   source,
                                                   target,
                                                   This,
                                                   MAssociationId);
            obj.close();
            callable.close();
            MAssociationICProxi inCache = (MAssociationICProxi)Cache.getTheCache().put(result);
            MAssociation objectInCache = (MAssociation)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MAssctnFacade.getClass(?); end;");
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
    public void nameSet(long MAssociationId, String nameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MAssctnFacade.nmSet(?, ?); end;");
            callable.setLong(1, MAssociationId);
            callable.setString(2, nameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void sourceSet(long MAssociationId, MType sourceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MAssctnFacade.srcSet(?, ?, ?); end;");
            callable.setLong(1, MAssociationId);
            callable.setLong(2, sourceVal.getId());
            callable.setLong(3, sourceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void targetSet(long MAssociationId, MType targetVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MAssctnFacade.trgtSet(?, ?, ?); end;");
            callable.setLong(1, MAssociationId);
            callable.setLong(2, targetVal.getId());
            callable.setLong(3, targetVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long hierarchiesAdd(long MAssociationId, PersistentMAHierarchy hierarchiesVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MAssctnFacade.hrrchsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, MAssociationId);
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
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MAssctnFacade.hrrchsRem(?); end;");
            callable.setLong(1, hierarchiesId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public MAHierarchyList hierarchiesGet(long MAssociationId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MAssctnFacade.hrrchsGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, MAssociationId);
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
    public void ThisSet(long MAssociationId, PersistentMAssociation ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MAssctnFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, MAssociationId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public MAssociationSearchList inverseGetHierarchies(long objectId, long classId)throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MAssctnFacade.iGetHrrchs(?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, objectId);
            callable.setLong(3, classId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            MAssociationSearchList result = new MAssociationSearchList();
            while (list.next()) {
                if (list.getLong(3) != 0) result.add((PersistentMAssociation)PersistentProxi.createProxi(list.getLong(3), list.getLong(4)));
                else result.add((PersistentMAssociation)PersistentProxi.createProxi(list.getLong(1), list.getLong(2)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

