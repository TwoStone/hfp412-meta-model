package persistence;

import model.typeSystem.*;

import java.sql.*;
import oracle.jdbc.*;

public class MObjectFacade{

	private String schemaName;
	private Connection con;

	public MObjectFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public MObjectProxi newMObject(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MObjctFacade.newMObjct(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            MObject result = new MObject(null,id);
            Cache.getTheCache().put(result);
            return (MObjectProxi)PersistentProxi.createProxi(id, 130);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MObjectProxi newDelayedMObject() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MObjctFacade.newDelayedMObjct(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            MObject result = new MObject(null,id);
            Cache.getTheCache().put(result);
            return (MObjectProxi)PersistentProxi.createProxi(id, 130);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MObject getMObject(long MObjectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MObjctFacade.getMObjct(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, MObjectId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentMObject This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentMObject)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            MObject result = new MObject(This,
                                         MObjectId);
            obj.close();
            callable.close();
            MObjectICProxi inCache = (MObjectICProxi)Cache.getTheCache().put(result);
            MObject objectInCache = (MObject)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MObjctFacade.getClass(?); end;");
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
    public void ThisSet(long MObjectId, PersistentMObject ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MObjctFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, MObjectId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

