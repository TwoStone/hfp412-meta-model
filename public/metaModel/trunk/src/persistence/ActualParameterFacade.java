package persistence;

import model.messageOrLink.*;

import java.sql.*;
import oracle.jdbc.*;

public class ActualParameterFacade{

	private String schemaName;
	private Connection con;

	public ActualParameterFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public ActualParameterProxi newActualParameter(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".ActlPrmtrFacade.newActlPrmtr(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ActualParameter result = new ActualParameter(null,null,null,id);
            Cache.getTheCache().put(result);
            return (ActualParameterProxi)PersistentProxi.createProxi(id, 196);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ActualParameterProxi newDelayedActualParameter() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".ActlPrmtrFacade.newDelayedActlPrmtr(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ActualParameter result = new ActualParameter(null,null,null,id);
            Cache.getTheCache().put(result);
            return (ActualParameterProxi)PersistentProxi.createProxi(id, 196);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ActualParameter getActualParameter(long ActualParameterId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ActlPrmtrFacade.getActlPrmtr(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, ActualParameterId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentFormalParameter type = null;
            if (obj.getLong(2) != 0)
                type = (PersistentFormalParameter)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentInstanceObject value = null;
            if (obj.getLong(4) != 0)
                value = (PersistentInstanceObject)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentActualParameter This = null;
            if (obj.getLong(6) != 0)
                This = (PersistentActualParameter)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            ActualParameter result = new ActualParameter(type,
                                                         value,
                                                         This,
                                                         ActualParameterId);
            obj.close();
            callable.close();
            ActualParameterICProxi inCache = (ActualParameterICProxi)Cache.getTheCache().put(result);
            ActualParameter objectInCache = (ActualParameter)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ActlPrmtrFacade.getClass(?); end;");
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
    public void typeSet(long ActualParameterId, PersistentFormalParameter typeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ActlPrmtrFacade.tpSet(?, ?, ?); end;");
            callable.setLong(1, ActualParameterId);
            callable.setLong(2, typeVal.getId());
            callable.setLong(3, typeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void valueSet(long ActualParameterId, PersistentInstanceObject valueVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ActlPrmtrFacade.vlSet(?, ?, ?); end;");
            callable.setLong(1, ActualParameterId);
            callable.setLong(2, valueVal.getId());
            callable.setLong(3, valueVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long ActualParameterId, PersistentActualParameter ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ActlPrmtrFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, ActualParameterId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

