package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class CreateQuantityCommandFacade{

	private String schemaName;
	private Connection con;

	public CreateQuantityCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CreateQuantityCommandProxi newCreateQuantityCommand(common.Fraction amount,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtQnttCMDFacade.newCrtQnttCMD(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, amount.toString());
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateQuantityCommand result = new CreateQuantityCommand(null,amount,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateQuantityCommandProxi)PersistentProxi.createProxi(id, 131);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateQuantityCommandProxi newDelayedCreateQuantityCommand(common.Fraction amount) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtQnttCMDFacade.newDelayedCrtQnttCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateQuantityCommand result = new CreateQuantityCommand(null,amount,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateQuantityCommandProxi)PersistentProxi.createProxi(id, 131);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateQuantityCommand getCreateQuantityCommand(long CreateQuantityCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtQnttCMDFacade.getCrtQnttCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CreateQuantityCommandId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentAbsUnit unit = null;
            if (obj.getLong(2) != 0)
                unit = (PersistentAbsUnit)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            Invoker invoker = null;
            if (obj.getLong(5) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            PersistentQuantityManager commandReceiver = null;
            if (obj.getLong(7) != 0)
                commandReceiver = (PersistentQuantityManager)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(9) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(9), obj.getLong(10));
            CreateQuantityCommand result = new CreateQuantityCommand(unit,
                                                                     common.Fraction.parse(obj.getString(4)),
                                                                     invoker,
                                                                     commandReceiver,
                                                                     myCommonDate,
                                                                     CreateQuantityCommandId);
            obj.close();
            callable.close();
            CreateQuantityCommandICProxi inCache = (CreateQuantityCommandICProxi)Cache.getTheCache().put(result);
            CreateQuantityCommand objectInCache = (CreateQuantityCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtQnttCMDFacade.getClass(?); end;");
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
    public void unitSet(long CreateQuantityCommandId, PersistentAbsUnit unitVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtQnttCMDFacade.untSet(?, ?, ?); end;");
            callable.setLong(1, CreateQuantityCommandId);
            callable.setLong(2, unitVal.getId());
            callable.setLong(3, unitVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void amountSet(long CreateQuantityCommandId, common.Fraction amountVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtQnttCMDFacade.amntSet(?, ?); end;");
            callable.setLong(1, CreateQuantityCommandId);
            callable.setString(2, amountVal.toString());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long CreateQuantityCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtQnttCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, CreateQuantityCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long CreateQuantityCommandId, PersistentQuantityManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtQnttCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, CreateQuantityCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long CreateQuantityCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtQnttCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, CreateQuantityCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

