package persistence;

import model.quantity.*;

import java.sql.*;
import oracle.jdbc.*;

public class FractionManagerFacade{

	private String schemaName;
	private Connection con;

	public FractionManagerFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public FractionManagerProxi getTheFractionManager() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".FrctnMngrFacade.getTheFrctnMngr; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (FractionManagerProxi)PersistentProxi.createProxi(id, 178);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public FractionManager getFractionManager(long FractionManagerId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".FrctnMngrFacade.getFrctnMngr(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, FractionManagerId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentFractionManager This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentFractionManager)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            FractionManager result = new FractionManager(This,
                                                         FractionManagerId);
            obj.close();
            callable.close();
            FractionManagerICProxi inCache = (FractionManagerICProxi)Cache.getTheCache().put(result);
            FractionManager objectInCache = (FractionManager)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".FrctnMngrFacade.getClass(?); end;");
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
    public void ThisSet(long FractionManagerId, PersistentFractionManager ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".FrctnMngrFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, FractionManagerId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

