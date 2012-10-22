package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class AddRoleCommandFacade{

	private String schemaName;
	private Connection con;

	public AddRoleCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public AddRoleCommandProxi newAddRoleCommand(String roleName) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AddRlCMDFacade.newAddRlCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, roleName);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AddRoleCommand result = new AddRoleCommand(null,roleName,null,null,null,id);
            Cache.getTheCache().put(result);
            return (AddRoleCommandProxi)PersistentProxi.createProxi(id, 105);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AddRoleCommand getAddRoleCommand(long AddRoleCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AddRlCMDFacade.getAddRlCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AddRoleCommandId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentActor actor = null;
            if (obj.getLong(2) != 0)
                actor = (PersistentActor)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            Invoker invoker = null;
            if (obj.getLong(5) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            PersistentActorManager commandReceiver = null;
            if (obj.getLong(7) != 0)
                commandReceiver = (PersistentActorManager)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(9) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(9), obj.getLong(10));
            AddRoleCommand result = new AddRoleCommand(actor,
                                                       obj.getString(4) == null ? "" : obj.getString(4) /* In Oracle "" = null !!! */,
                                                       invoker,
                                                       commandReceiver,
                                                       myCommonDate,
                                                       AddRoleCommandId);
            obj.close();
            callable.close();
            AddRoleCommandICProxi inCache = (AddRoleCommandICProxi)Cache.getTheCache().put(result);
            AddRoleCommand objectInCache = (AddRoleCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AddRlCMDFacade.getClass(?); end;");
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
    public void actorSet(long AddRoleCommandId, PersistentActor actorVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddRlCMDFacade.actrSet(?, ?, ?); end;");
            callable.setLong(1, AddRoleCommandId);
            callable.setLong(2, actorVal.getId());
            callable.setLong(3, actorVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void roleNameSet(long AddRoleCommandId, String roleNameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddRlCMDFacade.rlNmSet(?, ?); end;");
            callable.setLong(1, AddRoleCommandId);
            callable.setString(2, roleNameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long AddRoleCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddRlCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, AddRoleCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long AddRoleCommandId, PersistentActorManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddRlCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, AddRoleCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long AddRoleCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddRlCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, AddRoleCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

