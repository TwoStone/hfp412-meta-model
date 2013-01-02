package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class FinishModelingCommandFacade{

	private String schemaName;
	private Connection con;

	public FinishModelingCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public FinishModelingCommandProxi newFinishModelingCommand(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".FnshMdlngCMDFacade.newFnshMdlngCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            FinishModelingCommand result = new FinishModelingCommand(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (FinishModelingCommandProxi)PersistentProxi.createProxi(id, 179);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public FinishModelingCommandProxi newDelayedFinishModelingCommand() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".FnshMdlngCMDFacade.newDelayedFnshMdlngCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            FinishModelingCommand result = new FinishModelingCommand(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (FinishModelingCommandProxi)PersistentProxi.createProxi(id, 179);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public FinishModelingCommand getFinishModelingCommand(long FinishModelingCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".FnshMdlngCMDFacade.getFnshMdlngCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, FinishModelingCommandId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentCompUnitType compUnitType = null;
            if (obj.getLong(2) != 0)
                compUnitType = (PersistentCompUnitType)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            Invoker invoker = null;
            if (obj.getLong(4) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentUnitTypeManager commandReceiver = null;
            if (obj.getLong(6) != 0)
                commandReceiver = (PersistentUnitTypeManager)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(8) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            FinishModelingCommand result = new FinishModelingCommand(compUnitType,
                                                                     invoker,
                                                                     commandReceiver,
                                                                     myCommonDate,
                                                                     FinishModelingCommandId);
            obj.close();
            callable.close();
            FinishModelingCommandICProxi inCache = (FinishModelingCommandICProxi)Cache.getTheCache().put(result);
            FinishModelingCommand objectInCache = (FinishModelingCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".FnshMdlngCMDFacade.getClass(?); end;");
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
    public void compUnitTypeSet(long FinishModelingCommandId, PersistentCompUnitType compUnitTypeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".FnshMdlngCMDFacade.cmpUntTpSet(?, ?, ?); end;");
            callable.setLong(1, FinishModelingCommandId);
            callable.setLong(2, compUnitTypeVal.getId());
            callable.setLong(3, compUnitTypeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long FinishModelingCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".FnshMdlngCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, FinishModelingCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long FinishModelingCommandId, PersistentUnitTypeManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".FnshMdlngCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, FinishModelingCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long FinishModelingCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".FnshMdlngCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, FinishModelingCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

