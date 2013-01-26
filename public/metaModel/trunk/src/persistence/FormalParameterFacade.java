package persistence;

import model.abstractOperation.*;

import java.sql.*;
import oracle.jdbc.*;

public class FormalParameterFacade{

	private String schemaName;
	private Connection con;

	public FormalParameterFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public FormalParameterProxi newFormalParameter(String name,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".FrmlPrmtrFacade.newFrmlPrmtr(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            FormalParameter result = new FormalParameter(null,name,null,id);
            Cache.getTheCache().put(result);
            return (FormalParameterProxi)PersistentProxi.createProxi(id, 119);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public FormalParameterProxi newDelayedFormalParameter(String name) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".FrmlPrmtrFacade.newDelayedFrmlPrmtr(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            FormalParameter result = new FormalParameter(null,name,null,id);
            Cache.getTheCache().put(result);
            return (FormalParameterProxi)PersistentProxi.createProxi(id, 119);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public FormalParameter getFormalParameter(long FormalParameterId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".FrmlPrmtrFacade.getFrmlPrmtr(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, FormalParameterId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentMType ofType = null;
            if (obj.getLong(2) != 0)
                ofType = (PersistentMType)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentFormalParameter This = null;
            if (obj.getLong(5) != 0)
                This = (PersistentFormalParameter)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            FormalParameter result = new FormalParameter(ofType,
                                                         obj.getString(4) == null ? "" : obj.getString(4) /* In Oracle "" = null !!! */,
                                                         This,
                                                         FormalParameterId);
            obj.close();
            callable.close();
            FormalParameterICProxi inCache = (FormalParameterICProxi)Cache.getTheCache().put(result);
            FormalParameter objectInCache = (FormalParameter)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".FrmlPrmtrFacade.getClass(?); end;");
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
    public FormalParameterSearchList getFormalParameterByName(String name) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".FrmlPrmtrFacade.getFrmlPrmtrByNm(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setString(2, name);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            FormalParameterSearchList result = new FormalParameterSearchList();
            while (list.next()) {
                long classId = list.getLong(2);
                long objectId = list.getLong(1);
                FormalParameterProxi proxi = (FormalParameterProxi)PersistentProxi.createProxi(objectId, classId);
                result.add(proxi);
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ofTypeSet(long FormalParameterId, PersistentMType ofTypeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".FrmlPrmtrFacade.ofTpSet(?, ?, ?); end;");
            callable.setLong(1, FormalParameterId);
            callable.setLong(2, ofTypeVal.getId());
            callable.setLong(3, ofTypeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void nameSet(long FormalParameterId, String nameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".FrmlPrmtrFacade.nmSet(?, ?); end;");
            callable.setLong(1, FormalParameterId);
            callable.setString(2, nameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long FormalParameterId, PersistentFormalParameter ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".FrmlPrmtrFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, FormalParameterId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

