package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class CreateConversionCommandFacade{

	private String schemaName;
	private Connection con;

	public CreateConversionCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CreateConversionCommandProxi newCreateConversionCommand(common.Fraction factor,common.Fraction constant,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtCnvrsnCMDFacade.newCrtCnvrsnCMD(?,?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, factor.toString());
            callable.setString(3, constant.toString());
            callable.setLong(4, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateConversionCommand result = new CreateConversionCommand(null,factor,constant,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateConversionCommandProxi)PersistentProxi.createProxi(id, 156);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateConversionCommandProxi newDelayedCreateConversionCommand(common.Fraction factor,common.Fraction constant) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtCnvrsnCMDFacade.newDelayedCrtCnvrsnCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateConversionCommand result = new CreateConversionCommand(null,factor,constant,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateConversionCommandProxi)PersistentProxi.createProxi(id, 156);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateConversionCommand getCreateConversionCommand(long CreateConversionCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtCnvrsnCMDFacade.getCrtCnvrsnCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CreateConversionCommandId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentUnit unit = null;
            if (obj.getLong(2) != 0)
                unit = (PersistentUnit)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            Invoker invoker = null;
            if (obj.getLong(6) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentConversionManager commandReceiver = null;
            if (obj.getLong(8) != 0)
                commandReceiver = (PersistentConversionManager)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(10) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(10), obj.getLong(11));
            CreateConversionCommand result = new CreateConversionCommand(unit,
                                                                         common.Fraction.parse(obj.getString(4)),
                                                                         common.Fraction.parse(obj.getString(5)),
                                                                         invoker,
                                                                         commandReceiver,
                                                                         myCommonDate,
                                                                         CreateConversionCommandId);
            obj.close();
            callable.close();
            CreateConversionCommandICProxi inCache = (CreateConversionCommandICProxi)Cache.getTheCache().put(result);
            CreateConversionCommand objectInCache = (CreateConversionCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtCnvrsnCMDFacade.getClass(?); end;");
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
    public void unitSet(long CreateConversionCommandId, PersistentUnit unitVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtCnvrsnCMDFacade.untSet(?, ?, ?); end;");
            callable.setLong(1, CreateConversionCommandId);
            callable.setLong(2, unitVal.getId());
            callable.setLong(3, unitVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void factorSet(long CreateConversionCommandId, common.Fraction factorVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtCnvrsnCMDFacade.fctrSet(?, ?); end;");
            callable.setLong(1, CreateConversionCommandId);
            callable.setString(2, factorVal.toString());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void constantSet(long CreateConversionCommandId, common.Fraction constantVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtCnvrsnCMDFacade.cnstntSet(?, ?); end;");
            callable.setLong(1, CreateConversionCommandId);
            callable.setString(2, constantVal.toString());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long CreateConversionCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtCnvrsnCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, CreateConversionCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long CreateConversionCommandId, PersistentConversionManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtCnvrsnCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, CreateConversionCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long CreateConversionCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtCnvrsnCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, CreateConversionCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

