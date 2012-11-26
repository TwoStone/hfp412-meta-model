package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class MTrueFacade{

	private String schemaName;
	private Connection con;

	public MTrueFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public MTrueProxi getTheMTrue() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MTrFacade.getTheMTr; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (MTrueProxi)PersistentProxi.createProxi(id, 138);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MTrue getMTrue(long MTrueId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MTrFacade.getMTr(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, MTrueId);
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
            MTrue result = new MTrue(This,
                                     MTrueId);
            obj.close();
            callable.close();
            MTrueICProxi inCache = (MTrueICProxi)Cache.getTheCache().put(result);
            MTrue objectInCache = (MTrue)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

