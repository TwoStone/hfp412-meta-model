package persistence;

import model.abstractOperation.*;

import java.sql.*;
import oracle.jdbc.*;

public class HierarchyFacade{

	private String schemaName;
	private Connection con;

	public HierarchyFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public HierarchyProxi newHierarchy(String name,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".HrrchFacade.newHrrch(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Hierarchy result = new Hierarchy(name,null,id);
            Cache.getTheCache().put(result);
            return (HierarchyProxi)PersistentProxi.createProxi(id, 165);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public HierarchyProxi newDelayedHierarchy(String name) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".HrrchFacade.newDelayedHrrch(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Hierarchy result = new Hierarchy(name,null,id);
            Cache.getTheCache().put(result);
            return (HierarchyProxi)PersistentProxi.createProxi(id, 165);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Hierarchy getHierarchy(long HierarchyId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".HrrchFacade.getHrrch(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, HierarchyId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentHierarchy This = null;
            if (obj.getLong(3) != 0)
                This = (PersistentHierarchy)PersistentProxi.createProxi(obj.getLong(3), obj.getLong(4));
            Hierarchy result = new Hierarchy(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                             This,
                                             HierarchyId);
            obj.close();
            callable.close();
            HierarchyICProxi inCache = (HierarchyICProxi)Cache.getTheCache().put(result);
            Hierarchy objectInCache = (Hierarchy)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".HrrchFacade.getClass(?); end;");
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
    public HierarchySearchList getHierarchyByName(String name) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".HrrchFacade.getHrrchByNm(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setString(2, name);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            HierarchySearchList result = new HierarchySearchList();
            while (list.next()) {
                long classId = list.getLong(2);
                long objectId = list.getLong(1);
                HierarchyProxi proxi = (HierarchyProxi)PersistentProxi.createProxi(objectId, classId);
                result.add(proxi);
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void nameSet(long HierarchyId, String nameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".HrrchFacade.nmSet(?, ?); end;");
            callable.setLong(1, HierarchyId);
            callable.setString(2, nameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long HierarchyId, PersistentHierarchy ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".HrrchFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, HierarchyId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

