package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class MAHierarchyFacade{

	private String schemaName;
	private Connection con;

	public MAHierarchyFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public MAHierarchyProxi newMAHierarchy(String name,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MAHrrchFacade.newMAHrrch(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            MAHierarchy result = new MAHierarchy(name,null,id);
            Cache.getTheCache().put(result);
            return (MAHierarchyProxi)PersistentProxi.createProxi(id, 142);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MAHierarchyProxi newDelayedMAHierarchy(String name) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MAHrrchFacade.newDelayedMAHrrch(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            MAHierarchy result = new MAHierarchy(name,null,id);
            Cache.getTheCache().put(result);
            return (MAHierarchyProxi)PersistentProxi.createProxi(id, 142);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MAHierarchy getMAHierarchy(long MAHierarchyId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MAHrrchFacade.getMAHrrch(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, MAHierarchyId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentMAHierarchy This = null;
            if (obj.getLong(3) != 0)
                This = (PersistentMAHierarchy)PersistentProxi.createProxi(obj.getLong(3), obj.getLong(4));
            MAHierarchy result = new MAHierarchy(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                                 This,
                                                 MAHierarchyId);
            obj.close();
            callable.close();
            MAHierarchyICProxi inCache = (MAHierarchyICProxi)Cache.getTheCache().put(result);
            MAHierarchy objectInCache = (MAHierarchy)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MAHrrchFacade.getClass(?); end;");
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
    public MAHierarchySearchList getMAHierarchyByName(String name) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MAHrrchFacade.getMAHrrchByNm(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setString(2, name);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            MAHierarchySearchList result = new MAHierarchySearchList();
            while (list.next()) {
                long classId = list.getLong(2);
                long objectId = list.getLong(1);
                MAHierarchyProxi proxi = (MAHierarchyProxi)PersistentProxi.createProxi(objectId, classId);
                result.add(proxi);
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void nameSet(long MAHierarchyId, String nameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MAHrrchFacade.nmSet(?, ?); end;");
            callable.setLong(1, MAHierarchyId);
            callable.setString(2, nameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long MAHierarchyId, PersistentMAHierarchy ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MAHrrchFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, MAHierarchyId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

