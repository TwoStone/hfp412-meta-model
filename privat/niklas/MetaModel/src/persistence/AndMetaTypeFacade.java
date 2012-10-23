package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class AndMetaTypeFacade{

	private String schemaName;
	private Connection con;

	public AndMetaTypeFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public AndMetaTypeProxi newAndMetaType() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AndMtTpFacade.newAndMtTp; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AndMetaType result = new AndMetaType(null,id);
            Cache.getTheCache().put(result);
            return (AndMetaTypeProxi)PersistentProxi.createProxi(id, 118);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AndMetaType getAndMetaType(long AndMetaTypeId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AndMtTpFacade.getAndMtTp(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AndMetaTypeId);
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
            AndMetaType result = new AndMetaType(This,
                                                 AndMetaTypeId);
            obj.close();
            callable.close();
            AndMetaTypeICProxi inCache = (AndMetaTypeICProxi)Cache.getTheCache().put(result);
            AndMetaType objectInCache = (AndMetaType)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

