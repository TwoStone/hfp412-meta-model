package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class AddDefaultUnitCommandFacade{

	private String schemaName;
	private Connection con;

	public AddDefaultUnitCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public AddDefaultUnitCommandProxi newAddDefaultUnitCommand(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AddDfltUntCMDFacade.newAddDfltUntCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AddDefaultUnitCommand result = new AddDefaultUnitCommand(null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (AddDefaultUnitCommandProxi)PersistentProxi.createProxi(id, 177);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AddDefaultUnitCommandProxi newDelayedAddDefaultUnitCommand() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AddDfltUntCMDFacade.newDelayedAddDfltUntCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AddDefaultUnitCommand result = new AddDefaultUnitCommand(null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (AddDefaultUnitCommandProxi)PersistentProxi.createProxi(id, 177);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AddDefaultUnitCommand getAddDefaultUnitCommand(long AddDefaultUnitCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AddDfltUntCMDFacade.getAddDfltUntCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AddDefaultUnitCommandId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentAbsUnitType type = null;
            if (obj.getLong(2) != 0)
                type = (PersistentAbsUnitType)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentAbsUnit unit = null;
            if (obj.getLong(4) != 0)
                unit = (PersistentAbsUnit)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            Invoker invoker = null;
            if (obj.getLong(6) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentUnitTypeManager commandReceiver = null;
            if (obj.getLong(8) != 0)
                commandReceiver = (PersistentUnitTypeManager)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(10) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(10), obj.getLong(11));
            AddDefaultUnitCommand result = new AddDefaultUnitCommand(type,
                                                                     unit,
                                                                     invoker,
                                                                     commandReceiver,
                                                                     myCommonDate,
                                                                     AddDefaultUnitCommandId);
            obj.close();
            callable.close();
            AddDefaultUnitCommandICProxi inCache = (AddDefaultUnitCommandICProxi)Cache.getTheCache().put(result);
            AddDefaultUnitCommand objectInCache = (AddDefaultUnitCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AddDfltUntCMDFacade.getClass(?); end;");
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
    public void typeSet(long AddDefaultUnitCommandId, PersistentAbsUnitType typeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddDfltUntCMDFacade.tpSet(?, ?, ?); end;");
            callable.setLong(1, AddDefaultUnitCommandId);
            callable.setLong(2, typeVal.getId());
            callable.setLong(3, typeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void unitSet(long AddDefaultUnitCommandId, PersistentAbsUnit unitVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddDfltUntCMDFacade.untSet(?, ?, ?); end;");
            callable.setLong(1, AddDefaultUnitCommandId);
            callable.setLong(2, unitVal.getId());
            callable.setLong(3, unitVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long AddDefaultUnitCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddDfltUntCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, AddDefaultUnitCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long AddDefaultUnitCommandId, PersistentUnitTypeManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddDfltUntCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, AddDefaultUnitCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long AddDefaultUnitCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddDfltUntCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, AddDefaultUnitCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

