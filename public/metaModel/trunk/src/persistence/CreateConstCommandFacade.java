package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class CreateConstCommandFacade{

	private String schemaName;
	private Connection con;

	public CreateConstCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CreateConstCommandProxi newCreateConstCommand(String name,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtCnstCMDFacade.newCrtCnstCMD(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateConstCommand result = new CreateConstCommand(null,name,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateConstCommandProxi)PersistentProxi.createProxi(id, 176);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateConstCommandProxi newDelayedCreateConstCommand(String name) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtCnstCMDFacade.newDelayedCrtCnstCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateConstCommand result = new CreateConstCommand(null,name,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateConstCommandProxi)PersistentProxi.createProxi(id, 176);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateConstCommand getCreateConstCommand(long CreateConstCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtCnstCMDFacade.getCrtCnstCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CreateConstCommandId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentOperation type = null;
            if (obj.getLong(2) != 0)
                type = (PersistentOperation)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentInstanceObject target = null;
            if (obj.getLong(5) != 0)
                target = (PersistentInstanceObject)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            Invoker invoker = null;
            if (obj.getLong(7) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            PersistentMessageManager commandReceiver = null;
            if (obj.getLong(9) != 0)
                commandReceiver = (PersistentMessageManager)PersistentProxi.createProxi(obj.getLong(9), obj.getLong(10));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(11) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(11), obj.getLong(12));
            CreateConstCommand result = new CreateConstCommand(type,
                                                               obj.getString(4) == null ? "" : obj.getString(4) /* In Oracle "" = null !!! */,
                                                               target,
                                                               invoker,
                                                               commandReceiver,
                                                               myCommonDate,
                                                               CreateConstCommandId);
            obj.close();
            callable.close();
            CreateConstCommandICProxi inCache = (CreateConstCommandICProxi)Cache.getTheCache().put(result);
            CreateConstCommand objectInCache = (CreateConstCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtCnstCMDFacade.getClass(?); end;");
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
    public void typeSet(long CreateConstCommandId, PersistentOperation typeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtCnstCMDFacade.tpSet(?, ?, ?); end;");
            callable.setLong(1, CreateConstCommandId);
            callable.setLong(2, typeVal.getId());
            callable.setLong(3, typeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void nameSet(long CreateConstCommandId, String nameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtCnstCMDFacade.nmSet(?, ?); end;");
            callable.setLong(1, CreateConstCommandId);
            callable.setString(2, nameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void targetSet(long CreateConstCommandId, PersistentInstanceObject targetVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtCnstCMDFacade.trgtSet(?, ?, ?); end;");
            callable.setLong(1, CreateConstCommandId);
            callable.setLong(2, targetVal.getId());
            callable.setLong(3, targetVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long CreateConstCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtCnstCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, CreateConstCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long CreateConstCommandId, PersistentMessageManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtCnstCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, CreateConstCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long CreateConstCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtCnstCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, CreateConstCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

