package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class MBooleanFacade{

	private String schemaName;
	private Connection con;

	public MBooleanFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public MBooleanProxi getTheMBoolean() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MBlnFacade.getTheMBln; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (MBooleanProxi)PersistentProxi.createProxi(id, 137);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MBoolean getMBoolean(long MBooleanId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MBlnFacade.getMBln(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, MBooleanId);
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
            MBoolean result = new MBoolean(This,
                                           MBooleanId);
            obj.close();
            callable.close();
            MBooleanICProxi inCache = (MBooleanICProxi)Cache.getTheCache().put(result);
            MBoolean objectInCache = (MBoolean)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MBlnFacade.getClass(?); end;");
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
    public void ThisSet(long MBooleanId, PersistentMBoolean ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MBlnFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, MBooleanId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

