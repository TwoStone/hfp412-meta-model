package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class AddSubTypeCommandFacade{

	private String schemaName;
	private Connection con;

	public AddSubTypeCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public AddSubTypeCommandProxi newAddSubTypeCommand(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AddSbTpCMDFacade.newAddSbTpCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AddSubTypeCommand result = new AddSubTypeCommand(null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (AddSubTypeCommandProxi)PersistentProxi.createProxi(id, 133);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AddSubTypeCommandProxi newDelayedAddSubTypeCommand() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AddSbTpCMDFacade.newDelayedAddSbTpCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AddSubTypeCommand result = new AddSubTypeCommand(null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (AddSubTypeCommandProxi)PersistentProxi.createProxi(id, 133);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AddSubTypeCommand getAddSubTypeCommand(long AddSubTypeCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AddSbTpCMDFacade.getAddSbTpCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AddSubTypeCommandId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentMAtomicType superType = null;
            if (obj.getLong(2) != 0)
                superType = (PersistentMAtomicType)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentMAtomicType typeunder = null;
            if (obj.getLong(4) != 0)
                typeunder = (PersistentMAtomicType)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            Invoker invoker = null;
            if (obj.getLong(6) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentTypeManager commandReceiver = null;
            if (obj.getLong(8) != 0)
                commandReceiver = (PersistentTypeManager)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(10) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(10), obj.getLong(11));
            AddSubTypeCommand result = new AddSubTypeCommand(superType,
                                                             typeunder,
                                                             invoker,
                                                             commandReceiver,
                                                             myCommonDate,
                                                             AddSubTypeCommandId);
            obj.close();
            callable.close();
            AddSubTypeCommandICProxi inCache = (AddSubTypeCommandICProxi)Cache.getTheCache().put(result);
            AddSubTypeCommand objectInCache = (AddSubTypeCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AddSbTpCMDFacade.getClass(?); end;");
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
    public void superTypeSet(long AddSubTypeCommandId, PersistentMAtomicType superTypeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddSbTpCMDFacade.sprTpSet(?, ?, ?); end;");
            callable.setLong(1, AddSubTypeCommandId);
            callable.setLong(2, superTypeVal.getId());
            callable.setLong(3, superTypeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void typeunderSet(long AddSubTypeCommandId, PersistentMAtomicType typeunderVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddSbTpCMDFacade.tpndrSet(?, ?, ?); end;");
            callable.setLong(1, AddSubTypeCommandId);
            callable.setLong(2, typeunderVal.getId());
            callable.setLong(3, typeunderVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long AddSubTypeCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddSbTpCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, AddSubTypeCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long AddSubTypeCommandId, PersistentTypeManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddSbTpCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, AddSubTypeCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long AddSubTypeCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddSbTpCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, AddSubTypeCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

