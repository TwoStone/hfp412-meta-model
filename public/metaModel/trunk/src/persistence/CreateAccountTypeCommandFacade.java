package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class CreateAccountTypeCommandFacade{

	private String schemaName;
	private Connection con;

	public CreateAccountTypeCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CreateAccountTypeCommandProxi newCreateAccountTypeCommand(String name,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtAccntTpCMDFacade.newCrtAccntTpCMD(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateAccountTypeCommand result = new CreateAccountTypeCommand(name,null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateAccountTypeCommandProxi)PersistentProxi.createProxi(id, 147);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateAccountTypeCommandProxi newDelayedCreateAccountTypeCommand(String name) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtAccntTpCMDFacade.newDelayedCrtAccntTpCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateAccountTypeCommand result = new CreateAccountTypeCommand(name,null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateAccountTypeCommandProxi)PersistentProxi.createProxi(id, 147);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateAccountTypeCommand getCreateAccountTypeCommand(long CreateAccountTypeCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtAccntTpCMDFacade.getCrtAccntTpCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CreateAccountTypeCommandId);
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
            PersistentAccountTypeManager commandReceiver = null;
            if (obj.getLong(9) != 0)
                commandReceiver = (PersistentAccountTypeManager)PersistentProxi.createProxi(obj.getLong(9), obj.getLong(10));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(11) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(11), obj.getLong(12));
            CreateAccountTypeCommand result = new CreateAccountTypeCommand(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                                                           type,
                                                                           unitType,
                                                                           invoker,
                                                                           commandReceiver,
                                                                           myCommonDate,
                                                                           CreateAccountTypeCommandId);
            obj.close();
            callable.close();
            CreateAccountTypeCommandICProxi inCache = (CreateAccountTypeCommandICProxi)Cache.getTheCache().put(result);
            CreateAccountTypeCommand objectInCache = (CreateAccountTypeCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtAccntTpCMDFacade.getClass(?); end;");
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
    public void nameSet(long CreateAccountTypeCommandId, String nameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAccntTpCMDFacade.nmSet(?, ?); end;");
            callable.setLong(1, CreateAccountTypeCommandId);
            callable.setString(2, nameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void typeSet(long CreateAccountTypeCommandId, PersistentMType typeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAccntTpCMDFacade.tpSet(?, ?, ?); end;");
            callable.setLong(1, CreateAccountTypeCommandId);
            callable.setLong(2, typeVal.getId());
            callable.setLong(3, typeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void unitTypeSet(long CreateAccountTypeCommandId, PersistentUnitType unitTypeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAccntTpCMDFacade.untTpSet(?, ?, ?); end;");
            callable.setLong(1, CreateAccountTypeCommandId);
            callable.setLong(2, unitTypeVal.getId());
            callable.setLong(3, unitTypeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long CreateAccountTypeCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAccntTpCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, CreateAccountTypeCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long CreateAccountTypeCommandId, PersistentAccountTypeManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAccntTpCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, CreateAccountTypeCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long CreateAccountTypeCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAccntTpCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, CreateAccountTypeCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

