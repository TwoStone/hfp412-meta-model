package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class AddAtomicTypeCommandFacade{

	private String schemaName;
	private Connection con;

	public AddAtomicTypeCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public AddAtomicTypeCommandProxi newAddAtomicTypeCommand(String name) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AddAtmcTpCMDFacade.newAddAtmcTpCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AddAtomicTypeCommand result = new AddAtomicTypeCommand(null,name,null,null,null,id);
            Cache.getTheCache().put(result);
            return (AddAtomicTypeCommandProxi)PersistentProxi.createProxi(id, 122);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AddAtomicTypeCommand getAddAtomicTypeCommand(long AddAtomicTypeCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AddAtmcTpCMDFacade.getAddAtmcTpCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AddAtomicTypeCommandId);
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
            Invoker invoker = null;
            if (obj.getLong(5) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            PersistentTypeManager commandReceiver = null;
            if (obj.getLong(7) != 0)
                commandReceiver = (PersistentTypeManager)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(9) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(9), obj.getLong(10));
            AddAtomicTypeCommand result = new AddAtomicTypeCommand(aspect,
                                                                   obj.getString(4) == null ? "" : obj.getString(4) /* In Oracle "" = null !!! */,
                                                                   invoker,
                                                                   commandReceiver,
                                                                   myCommonDate,
                                                                   AddAtomicTypeCommandId);
            obj.close();
            callable.close();
            AddAtomicTypeCommandICProxi inCache = (AddAtomicTypeCommandICProxi)Cache.getTheCache().put(result);
            AddAtomicTypeCommand objectInCache = (AddAtomicTypeCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AddAtmcTpCMDFacade.getClass(?); end;");
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
    public void aspectSet(long AddAtomicTypeCommandId, PersistentMAspect aspectVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddAtmcTpCMDFacade.aspctSet(?, ?, ?); end;");
            callable.setLong(1, AddAtomicTypeCommandId);
            callable.setLong(2, aspectVal.getId());
            callable.setLong(3, aspectVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void nameSet(long AddAtomicTypeCommandId, String nameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddAtmcTpCMDFacade.nmSet(?, ?); end;");
            callable.setLong(1, AddAtomicTypeCommandId);
            callable.setString(2, nameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long AddAtomicTypeCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddAtmcTpCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, AddAtomicTypeCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long AddAtomicTypeCommandId, PersistentTypeManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddAtmcTpCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, AddAtomicTypeCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long AddAtomicTypeCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddAtmcTpCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, AddAtomicTypeCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

