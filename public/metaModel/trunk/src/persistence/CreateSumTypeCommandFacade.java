package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class CreateSumTypeCommandFacade{

	private String schemaName;
	private Connection con;

	public CreateSumTypeCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CreateSumTypeCommandProxi newCreateSumTypeCommand(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtSmTpCMDFacade.newCrtSmTpCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateSumTypeCommand result = new CreateSumTypeCommand(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateSumTypeCommandProxi)PersistentProxi.createProxi(id, 197);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateSumTypeCommandProxi newDelayedCreateSumTypeCommand() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtSmTpCMDFacade.newDelayedCrtSmTpCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateSumTypeCommand result = new CreateSumTypeCommand(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateSumTypeCommandProxi)PersistentProxi.createProxi(id, 197);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateSumTypeCommand getCreateSumTypeCommand(long CreateSumTypeCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtSmTpCMDFacade.getCrtSmTpCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CreateSumTypeCommandId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            Invoker invoker = null;
            if (obj.getLong(2) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentTypeManager commandReceiver = null;
            if (obj.getLong(4) != 0)
                commandReceiver = (PersistentTypeManager)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentMAbstractSumType commandResult = null;
            if (obj.getLong(6) != 0)
                commandResult = (PersistentMAbstractSumType)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(8) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            CreateSumTypeCommand result = new CreateSumTypeCommand(invoker,
                                                                   commandReceiver,
                                                                   commandResult,
                                                                   myCommonDate,
                                                                   CreateSumTypeCommandId);
            obj.close();
            callable.close();
            CreateSumTypeCommandICProxi inCache = (CreateSumTypeCommandICProxi)Cache.getTheCache().put(result);
            CreateSumTypeCommand objectInCache = (CreateSumTypeCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtSmTpCMDFacade.getClass(?); end;");
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
    public long addendsAdd(long CreateSumTypeCommandId, PersistentMType addendsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtSmTpCMDFacade.addndsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, CreateSumTypeCommandId);
            callable.setLong(3, addendsVal.getId());
            callable.setLong(4, addendsVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void addendsRem(long addendsId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtSmTpCMDFacade.addndsRem(?); end;");
            callable.setLong(1, addendsId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public MTypeList addendsGet(long CreateSumTypeCommandId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtSmTpCMDFacade.addndsGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CreateSumTypeCommandId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            MTypeList result = new MTypeList();
            while (list.next()) {
                result.add((PersistentMType)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long CreateSumTypeCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtSmTpCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, CreateSumTypeCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long CreateSumTypeCommandId, PersistentTypeManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtSmTpCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, CreateSumTypeCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandResultSet(long CreateSumTypeCommandId, PersistentMAbstractSumType commandResultVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtSmTpCMDFacade.cResultSet(?, ?, ?); end;");
            callable.setLong(1, CreateSumTypeCommandId);
            callable.setLong(2, commandResultVal.getId());
            callable.setLong(3, commandResultVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long CreateSumTypeCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtSmTpCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, CreateSumTypeCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

