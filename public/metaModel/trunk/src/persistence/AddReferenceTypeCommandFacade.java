package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class AddReferenceTypeCommandFacade{

	private String schemaName;
	private Connection con;

	public AddReferenceTypeCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public AddReferenceTypeCommandProxi newAddReferenceTypeCommand(long exponent,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AddRfrncTpCMDFacade.newAddRfrncTpCMD(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, exponent);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AddReferenceTypeCommand result = new AddReferenceTypeCommand(null,null,exponent,null,null,null,id);
            Cache.getTheCache().put(result);
            return (AddReferenceTypeCommandProxi)PersistentProxi.createProxi(id, 195);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AddReferenceTypeCommandProxi newDelayedAddReferenceTypeCommand(long exponent) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AddRfrncTpCMDFacade.newDelayedAddRfrncTpCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AddReferenceTypeCommand result = new AddReferenceTypeCommand(null,null,exponent,null,null,null,id);
            Cache.getTheCache().put(result);
            return (AddReferenceTypeCommandProxi)PersistentProxi.createProxi(id, 195);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AddReferenceTypeCommand getAddReferenceTypeCommand(long AddReferenceTypeCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AddRfrncTpCMDFacade.getAddRfrncTpCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AddReferenceTypeCommandId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentCompUnitType compUnitType = null;
            if (obj.getLong(2) != 0)
                compUnitType = (PersistentCompUnitType)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentUnitType unitType = null;
            if (obj.getLong(4) != 0)
                unitType = (PersistentUnitType)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            Invoker invoker = null;
            if (obj.getLong(7) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            PersistentUnitTypeManager commandReceiver = null;
            if (obj.getLong(9) != 0)
                commandReceiver = (PersistentUnitTypeManager)PersistentProxi.createProxi(obj.getLong(9), obj.getLong(10));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(11) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(11), obj.getLong(12));
            AddReferenceTypeCommand result = new AddReferenceTypeCommand(compUnitType,
                                                                         unitType,
                                                                         obj.getLong(6),
                                                                         invoker,
                                                                         commandReceiver,
                                                                         myCommonDate,
                                                                         AddReferenceTypeCommandId);
            obj.close();
            callable.close();
            AddReferenceTypeCommandICProxi inCache = (AddReferenceTypeCommandICProxi)Cache.getTheCache().put(result);
            AddReferenceTypeCommand objectInCache = (AddReferenceTypeCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AddRfrncTpCMDFacade.getClass(?); end;");
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
    public void compUnitTypeSet(long AddReferenceTypeCommandId, PersistentCompUnitType compUnitTypeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddRfrncTpCMDFacade.cmpUntTpSet(?, ?, ?); end;");
            callable.setLong(1, AddReferenceTypeCommandId);
            callable.setLong(2, compUnitTypeVal.getId());
            callable.setLong(3, compUnitTypeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void unitTypeSet(long AddReferenceTypeCommandId, PersistentUnitType unitTypeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddRfrncTpCMDFacade.untTpSet(?, ?, ?); end;");
            callable.setLong(1, AddReferenceTypeCommandId);
            callable.setLong(2, unitTypeVal.getId());
            callable.setLong(3, unitTypeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void exponentSet(long AddReferenceTypeCommandId, long exponentVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddRfrncTpCMDFacade.expnntSet(?, ?); end;");
            callable.setLong(1, AddReferenceTypeCommandId);
            callable.setLong(2, exponentVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long AddReferenceTypeCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddRfrncTpCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, AddReferenceTypeCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long AddReferenceTypeCommandId, PersistentUnitTypeManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddRfrncTpCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, AddReferenceTypeCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long AddReferenceTypeCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddRfrncTpCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, AddReferenceTypeCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

