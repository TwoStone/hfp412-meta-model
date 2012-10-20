package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class CONCNamedEntityFacade{

	private String schemaName;
	private Connection con;

	public CONCNamedEntityFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CONCNamedEntityProxi newCONCNamedEntity(String name) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CONCNmdEnttFacade.newCONCNmdEntt(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CONCNamedEntity result = new CONCNamedEntity(name,null,id);
            Cache.getTheCache().put(result);
            return (CONCNamedEntityProxi)PersistentProxi.createProxi(id, 128);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CONCNamedEntity getCONCNamedEntity(long CONCNamedEntityId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CONCNmdEnttFacade.getCONCNmdEntt(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CONCNamedEntityId);
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
            CONCNamedEntity result = new CONCNamedEntity(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                                         This,
                                                         CONCNamedEntityId);
            obj.close();
            callable.close();
            CONCNamedEntityICProxi inCache = (CONCNamedEntityICProxi)Cache.getTheCache().put(result);
            CONCNamedEntity objectInCache = (CONCNamedEntity)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

