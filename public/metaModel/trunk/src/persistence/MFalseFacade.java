package persistence;

import model.basic.*;

import java.sql.*;
import oracle.jdbc.*;

public class MFalseFacade{

	private String schemaName;
	private Connection con;

	public MFalseFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public MFalseProxi getTheMFalse() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MFlsFacade.getTheMFls; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (MFalseProxi)PersistentProxi.createProxi(id, 185);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MFalse getMFalse(long MFalseId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MFlsFacade.getMFls(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, MFalseId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentMBoolean This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentMBoolean)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            MFalse result = new MFalse(This,
                                       MFalseId);
            obj.close();
            callable.close();
            MFalseICProxi inCache = (MFalseICProxi)Cache.getTheCache().put(result);
            MFalse objectInCache = (MFalse)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

