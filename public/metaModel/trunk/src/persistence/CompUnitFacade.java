package persistence;

import model.quantity.*;

import java.sql.*;
import oracle.jdbc.*;

public class CompUnitFacade{

	private String schemaName;
	private Connection con;

	public CompUnitFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CompUnitProxi newCompUnit(String name,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpUntFacade.newCmpUnt(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CompUnit result = new CompUnit(null,name,null,null,id);
            Cache.getTheCache().put(result);
            return (CompUnitProxi)PersistentProxi.createProxi(id, 162);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CompUnitProxi newDelayedCompUnit(String name) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpUntFacade.newDelayedCmpUnt(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CompUnit result = new CompUnit(null,name,null,null,id);
            Cache.getTheCache().put(result);
            return (CompUnitProxi)PersistentProxi.createProxi(id, 162);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CompUnit getCompUnit(long CompUnitId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpUntFacade.getCmpUnt(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CompUnitId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentAbsUnitType type = null;
            if (obj.getLong(2) != 0)
                type = (PersistentAbsUnitType)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentAbsUnit This = null;
            if (obj.getLong(5) != 0)
                This = (PersistentAbsUnit)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            PersistentMBoolean isFinal = null;
            if (obj.getLong(7) != 0)
                isFinal = (PersistentMBoolean)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            CompUnit result = new CompUnit(type,
                                           obj.getString(4) == null ? "" : obj.getString(4) /* In Oracle "" = null !!! */,
                                           This,
                                           isFinal,
                                           CompUnitId);
            obj.close();
            callable.close();
            CompUnitICProxi inCache = (CompUnitICProxi)Cache.getTheCache().put(result);
            CompUnit objectInCache = (CompUnit)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long refsAdd(long CompUnitId, PersistentReference refsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpUntFacade.rfsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, CompUnitId);
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
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CmpUntFacade.rfsRem(?); end;");
            callable.setLong(1, refsId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public ReferenceList refsGet(long CompUnitId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpUntFacade.rfsGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CompUnitId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            ReferenceList result = new ReferenceList();
            while (list.next()) {
                result.add((PersistentReference)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void isFinalSet(long CompUnitId, PersistentMBoolean isFinalVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CmpUntFacade.isFnlSet(?, ?, ?); end;");
            callable.setLong(1, CompUnitId);
            callable.setLong(2, isFinalVal.getId());
            callable.setLong(3, isFinalVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

