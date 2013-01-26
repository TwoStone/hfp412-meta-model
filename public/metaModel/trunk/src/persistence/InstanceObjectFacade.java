package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class InstanceObjectFacade{

	private String schemaName;
	private Connection con;

	public InstanceObjectFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public InstanceObjectProxi newInstanceObject(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".InstncObjctFacade.newInstncObjct(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            InstanceObject result = new InstanceObject(null,null,id);
            Cache.getTheCache().put(result);
            return (InstanceObjectProxi)PersistentProxi.createProxi(id, 132);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public InstanceObjectProxi newDelayedInstanceObject() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".InstncObjctFacade.newDelayedInstncObjct(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            InstanceObject result = new InstanceObject(null,null,id);
            Cache.getTheCache().put(result);
            return (InstanceObjectProxi)PersistentProxi.createProxi(id, 132);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public InstanceObject getInstanceObject(long InstanceObjectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".InstncObjctFacade.getInstncObjct(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, InstanceObjectId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentMAtomicType type = null;
            if (obj.getLong(2) != 0)
                type = (PersistentMAtomicType)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentInstanceObject This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentInstanceObject)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            InstanceObject result = new InstanceObject(type,
                                                       This,
                                                       InstanceObjectId);
            obj.close();
            callable.close();
            InstanceObjectICProxi inCache = (InstanceObjectICProxi)Cache.getTheCache().put(result);
            InstanceObject objectInCache = (InstanceObject)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".InstncObjctFacade.getClass(?); end;");
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
    public void typeSet(long InstanceObjectId, PersistentMAtomicType typeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".InstncObjctFacade.tpSet(?, ?, ?); end;");
            callable.setLong(1, InstanceObjectId);
            callable.setLong(2, typeVal.getId());
            callable.setLong(3, typeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long InstanceObjectId, PersistentInstanceObject ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".InstncObjctFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, InstanceObjectId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

