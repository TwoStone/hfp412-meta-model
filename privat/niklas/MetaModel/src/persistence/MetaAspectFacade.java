package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class MetaAspectFacade{

	private String schemaName;
	private Connection con;

	public MetaAspectFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public MetaAspectProxi newMetaAspect(String name) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MtAspctFacade.newMtAspct(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            MetaAspect result = new MetaAspect(name,null,id);
            Cache.getTheCache().put(result);
            return (MetaAspectProxi)PersistentProxi.createProxi(id, 119);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MetaAspect getMetaAspect(long MetaAspectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MtAspctFacade.getMtAspct(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, MetaAspectId);
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
            MetaAspect result = new MetaAspect(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                               This,
                                               MetaAspectId);
            obj.close();
            callable.close();
            MetaAspectICProxi inCache = (MetaAspectICProxi)Cache.getTheCache().put(result);
            MetaAspect objectInCache = (MetaAspect)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

