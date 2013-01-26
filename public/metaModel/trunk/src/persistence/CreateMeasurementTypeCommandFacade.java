package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class CreateMeasurementTypeCommandFacade{

	private String schemaName;
	private Connection con;

	public CreateMeasurementTypeCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CreateMeasurementTypeCommandProxi newCreateMeasurementTypeCommand(String name,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtMsrmntTpCMDFacade.newCrtMsrmntTpCMD(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateMeasurementTypeCommand result = new CreateMeasurementTypeCommand(name,null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateMeasurementTypeCommandProxi)PersistentProxi.createProxi(id, 125);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateMeasurementTypeCommandProxi newDelayedCreateMeasurementTypeCommand(String name) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtMsrmntTpCMDFacade.newDelayedCrtMsrmntTpCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateMeasurementTypeCommand result = new CreateMeasurementTypeCommand(name,null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateMeasurementTypeCommandProxi)PersistentProxi.createProxi(id, 125);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateMeasurementTypeCommand getCreateMeasurementTypeCommand(long CreateMeasurementTypeCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtMsrmntTpCMDFacade.getCrtMsrmntTpCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CreateMeasurementTypeCommandId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentMType type = null;
            if (obj.getLong(3) != 0)
                type = (PersistentMType)PersistentProxi.createProxi(obj.getLong(3), obj.getLong(4));
            PersistentUnitType unitType = null;
            if (obj.getLong(5) != 0)
                unitType = (PersistentUnitType)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            Invoker invoker = null;
            if (obj.getLong(7) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            PersistentMeasurementTypeManager commandReceiver = null;
            if (obj.getLong(9) != 0)
                commandReceiver = (PersistentMeasurementTypeManager)PersistentProxi.createProxi(obj.getLong(9), obj.getLong(10));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(11) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(11), obj.getLong(12));
            CreateMeasurementTypeCommand result = new CreateMeasurementTypeCommand(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                                                                   type,
                                                                                   unitType,
                                                                                   invoker,
                                                                                   commandReceiver,
                                                                                   myCommonDate,
                                                                                   CreateMeasurementTypeCommandId);
            obj.close();
            callable.close();
            CreateMeasurementTypeCommandICProxi inCache = (CreateMeasurementTypeCommandICProxi)Cache.getTheCache().put(result);
            CreateMeasurementTypeCommand objectInCache = (CreateMeasurementTypeCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtMsrmntTpCMDFacade.getClass(?); end;");
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
    public void nameSet(long CreateMeasurementTypeCommandId, String nameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtMsrmntTpCMDFacade.nmSet(?, ?); end;");
            callable.setLong(1, CreateMeasurementTypeCommandId);
            callable.setString(2, nameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void typeSet(long CreateMeasurementTypeCommandId, PersistentMType typeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtMsrmntTpCMDFacade.tpSet(?, ?, ?); end;");
            callable.setLong(1, CreateMeasurementTypeCommandId);
            callable.setLong(2, typeVal.getId());
            callable.setLong(3, typeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void unitTypeSet(long CreateMeasurementTypeCommandId, PersistentUnitType unitTypeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtMsrmntTpCMDFacade.untTpSet(?, ?, ?); end;");
            callable.setLong(1, CreateMeasurementTypeCommandId);
            callable.setLong(2, unitTypeVal.getId());
            callable.setLong(3, unitTypeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long CreateMeasurementTypeCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtMsrmntTpCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, CreateMeasurementTypeCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long CreateMeasurementTypeCommandId, PersistentMeasurementTypeManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtMsrmntTpCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, CreateMeasurementTypeCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long CreateMeasurementTypeCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtMsrmntTpCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, CreateMeasurementTypeCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

