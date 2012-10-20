package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class MetaHierarchyFacade{

	private String schemaName;
	private Connection con;

	public MetaHierarchyFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public MetaHierarchyProxi newMetaHierarchy(String name) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MtHrrchFacade.newMtHrrch(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            MetaHierarchy result = new MetaHierarchy(name,null,id);
            Cache.getTheCache().put(result);
            return (MetaHierarchyProxi)PersistentProxi.createProxi(id, 121);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MetaHierarchy getMetaHierarchy(long MetaHierarchyId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MtHrrchFacade.getMtHrrch(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, MetaHierarchyId);
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
            MetaHierarchy result = new MetaHierarchy(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                                     This,
                                                     MetaHierarchyId);
            obj.close();
            callable.close();
            MetaHierarchyICProxi inCache = (MetaHierarchyICProxi)Cache.getTheCache().put(result);
            MetaHierarchy objectInCache = (MetaHierarchy)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

