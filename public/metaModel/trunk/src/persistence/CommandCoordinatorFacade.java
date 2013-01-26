package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class CommandCoordinatorFacade{

	private String schemaName;
	private Connection con;

	public CommandCoordinatorFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CommandCoordinatorProxi getTheCommandCoordinator() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmmndCrdntrFacade.getTheCmmndCrdntr; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (CommandCoordinatorProxi)PersistentProxi.createProxi(id, -128);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CommandCoordinator getCommandCoordinator(long CommandCoordinatorId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmmndCrdntrFacade.getCmmndCrdntr(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CommandCoordinatorId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            CommandCoordinator result = new CommandCoordinator(CommandCoordinatorId);
            obj.close();
            callable.close();
            CommandCoordinatorICProxi inCache = (CommandCoordinatorICProxi)Cache.getTheCache().put(result);
            CommandCoordinator objectInCache = (CommandCoordinator)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmmndCrdntrFacade.getClass(?); end;");
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
    public long executerAdd(long CommandCoordinatorId, PersistentCommandExecuter executerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmmndCrdntrFacade.exctrAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, CommandCoordinatorId);
            callable.setLong(3, executerVal.getId());
            callable.setLong(4, executerVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void executerRem(long executerId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CmmndCrdntrFacade.exctrRem(?); end;");
            callable.setLong(1, executerId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public CommandExecuterList executerGet(long CommandCoordinatorId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmmndCrdntrFacade.exctrGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CommandCoordinatorId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            CommandExecuterList result = new CommandExecuterList();
            while (list.next()) {
                result.add((PersistentCommandExecuter)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

