package persistence;

import model.quantity.*;

import java.sql.*;
import oracle.jdbc.*;

public class CompUnitTypeFacade{

	private String schemaName;
	private Connection con;

	public CompUnitTypeFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CompUnitTypeProxi newCompUnitType(String name,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpUntTpFacade.newCmpUntTp(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CompUnitType result = new CompUnitType(name,null,null,id);
            Cache.getTheCache().put(result);
            return (CompUnitTypeProxi)PersistentProxi.createProxi(id, 114);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CompUnitTypeProxi newDelayedCompUnitType(String name) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpUntTpFacade.newDelayedCmpUntTp(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CompUnitType result = new CompUnitType(name,null,null,id);
            Cache.getTheCache().put(result);
            return (CompUnitTypeProxi)PersistentProxi.createProxi(id, 114);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CompUnitType getCompUnitType(long CompUnitTypeId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpUntTpFacade.getCmpUntTp(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CompUnitTypeId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentAbsUnitType This = null;
            if (obj.getLong(3) != 0)
                This = (PersistentAbsUnitType)PersistentProxi.createProxi(obj.getLong(3), obj.getLong(4));
            PersistentMBoolean isFinal = null;
            if (obj.getLong(5) != 0)
                isFinal = (PersistentMBoolean)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            CompUnitType result = new CompUnitType(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                                   This,
                                                   isFinal,
                                                   CompUnitTypeId);
            obj.close();
            callable.close();
            CompUnitTypeICProxi inCache = (CompUnitTypeICProxi)Cache.getTheCache().put(result);
            CompUnitType objectInCache = (CompUnitType)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long refsAdd(long CompUnitTypeId, PersistentReferenceType refsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpUntTpFacade.rfsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, CompUnitTypeId);
            callable.setLong(3, refsVal.getId());
            callable.setLong(4, refsVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void refsRem(long refsId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CmpUntTpFacade.rfsRem(?); end;");
            callable.setLong(1, refsId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public ReferenceTypeList refsGet(long CompUnitTypeId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpUntTpFacade.rfsGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CompUnitTypeId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            ReferenceTypeList result = new ReferenceTypeList();
            while (list.next()) {
                result.add((PersistentReferenceType)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void isFinalSet(long CompUnitTypeId, PersistentMBoolean isFinalVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CmpUntTpFacade.isFnlSet(?, ?, ?); end;");
            callable.setLong(1, CompUnitTypeId);
            callable.setLong(2, isFinalVal.getId());
            callable.setLong(3, isFinalVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

