package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class OrMetaTypeFacade{

	private String schemaName;
	private Connection con;

	public OrMetaTypeFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public OrMetaTypeProxi newOrMetaType() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".OrMtTpFacade.newOrMtTp; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            OrMetaType result = new OrMetaType(null,id);
            Cache.getTheCache().put(result);
            return (OrMetaTypeProxi)PersistentProxi.createProxi(id, 117);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public OrMetaType getOrMetaType(long OrMetaTypeId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".OrMtTpFacade.getOrMtTp(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, OrMetaTypeId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentAbstractMetaType This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentAbstractMetaType)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            OrMetaType result = new OrMetaType(This,
                                               OrMetaTypeId);
            obj.close();
            callable.close();
            OrMetaTypeICProxi inCache = (OrMetaTypeICProxi)Cache.getTheCache().put(result);
            OrMetaType objectInCache = (OrMetaType)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

