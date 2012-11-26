package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class CreateAtomicTypeCommandFacade{

	private String schemaName;
	private Connection con;

	public CreateAtomicTypeCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CreateAtomicTypeCommandProxi newCreateAtomicTypeCommand(String name,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtAtmcTpCMDFacade.newCrtAtmcTpCMD(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateAtomicTypeCommand result = new CreateAtomicTypeCommand(null,name,null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateAtomicTypeCommandProxi)PersistentProxi.createProxi(id, 140);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateAtomicTypeCommandProxi newDelayedCreateAtomicTypeCommand(String name) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtAtmcTpCMDFacade.newDelayedCrtAtmcTpCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateAtomicTypeCommand result = new CreateAtomicTypeCommand(null,name,null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateAtomicTypeCommandProxi)PersistentProxi.createProxi(id, 140);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateAtomicTypeCommand getCreateAtomicTypeCommand(long CreateAtomicTypeCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtAtmcTpCMDFacade.getCrtAtmcTpCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CreateAtomicTypeCommandId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentMAspect aspect = null;
            if (obj.getLong(2) != 0)
                aspect = (PersistentMAspect)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentMBoolean singletonType = null;
            if (obj.getLong(5) != 0)
                singletonType = (PersistentMBoolean)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            PersistentMBoolean abstractType = null;
            if (obj.getLong(7) != 0)
                abstractType = (PersistentMBoolean)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            Invoker invoker = null;
            if (obj.getLong(9) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(9), obj.getLong(10));
            PersistentTypeManager commandReceiver = null;
            if (obj.getLong(11) != 0)
                commandReceiver = (PersistentTypeManager)PersistentProxi.createProxi(obj.getLong(11), obj.getLong(12));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(13) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(13), obj.getLong(14));
            CreateAtomicTypeCommand result = new CreateAtomicTypeCommand(aspect,
                                                                         obj.getString(4) == null ? "" : obj.getString(4) /* In Oracle "" = null !!! */,
                                                                         singletonType,
                                                                         abstractType,
                                                                         invoker,
                                                                         commandReceiver,
                                                                         myCommonDate,
                                                                         CreateAtomicTypeCommandId);
            obj.close();
            callable.close();
            CreateAtomicTypeCommandICProxi inCache = (CreateAtomicTypeCommandICProxi)Cache.getTheCache().put(result);
            CreateAtomicTypeCommand objectInCache = (CreateAtomicTypeCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtAtmcTpCMDFacade.getClass(?); end;");
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
    public void aspectSet(long CreateAtomicTypeCommandId, PersistentMAspect aspectVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAtmcTpCMDFacade.aspctSet(?, ?, ?); end;");
            callable.setLong(1, CreateAtomicTypeCommandId);
            callable.setLong(2, aspectVal.getId());
            callable.setLong(3, aspectVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void nameSet(long CreateAtomicTypeCommandId, String nameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAtmcTpCMDFacade.nmSet(?, ?); end;");
            callable.setLong(1, CreateAtomicTypeCommandId);
            callable.setString(2, nameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void singletonTypeSet(long CreateAtomicTypeCommandId, PersistentMBoolean singletonTypeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAtmcTpCMDFacade.sngltnTpSet(?, ?, ?); end;");
            callable.setLong(1, CreateAtomicTypeCommandId);
            callable.setLong(2, singletonTypeVal.getId());
            callable.setLong(3, singletonTypeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void abstractTypeSet(long CreateAtomicTypeCommandId, PersistentMBoolean abstractTypeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAtmcTpCMDFacade.abstrctTpSet(?, ?, ?); end;");
            callable.setLong(1, CreateAtomicTypeCommandId);
            callable.setLong(2, abstractTypeVal.getId());
            callable.setLong(3, abstractTypeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long CreateAtomicTypeCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAtmcTpCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, CreateAtomicTypeCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long CreateAtomicTypeCommandId, PersistentTypeManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAtmcTpCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, CreateAtomicTypeCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long CreateAtomicTypeCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtAtmcTpCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, CreateAtomicTypeCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

