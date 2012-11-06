package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class MAtomicTypeFacade{

	private String schemaName;
	private Connection con;

	public MAtomicTypeFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public MAtomicTypeProxi newMAtomicType(String name) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MAtmcTpFacade.newMAtmcTp(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            MAtomicType result = new MAtomicType(name,null,null,null,id);
            Cache.getTheCache().put(result);
            return (MAtomicTypeProxi)PersistentProxi.createProxi(id, 102);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MAtomicType getMAtomicType(long MAtomicTypeId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MAtmcTpFacade.getMAtmcTp(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, MAtomicTypeId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentMAspect aspect = null;
            if (obj.getLong(3) != 0)
                aspect = (PersistentMAspect)PersistentProxi.createProxi(obj.getLong(3), obj.getLong(4));
            PersistentMAtomicType superType = null;
            if (obj.getLong(5) != 0)
                superType = (PersistentMAtomicType)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            PersistentMAtomicType This = null;
            if (obj.getLong(7) != 0)
                This = (PersistentMAtomicType)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            MAtomicType result = new MAtomicType(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                                 aspect,
                                                 superType,
                                                 This,
                                                 MAtomicTypeId);
            obj.close();
            callable.close();
            MAtomicTypeICProxi inCache = (MAtomicTypeICProxi)Cache.getTheCache().put(result);
            MAtomicType objectInCache = (MAtomicType)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MAtmcTpFacade.getClass(?); end;");
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
    public MAtomicTypeSearchList getMAtomicTypeByName(String name) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MAtmcTpFacade.getMAtmcTpByNm(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setString(2, name);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            MAtomicTypeSearchList result = new MAtomicTypeSearchList();
            while (list.next()) {
                long classId = list.getLong(2);
                long objectId = list.getLong(1);
                MAtomicTypeProxi proxi = (MAtomicTypeProxi)PersistentProxi.createProxi(objectId, classId);
                result.add(proxi);
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void nameSet(long MAtomicTypeId, String nameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MAtmcTpFacade.nmSet(?, ?); end;");
            callable.setLong(1, MAtomicTypeId);
            callable.setString(2, nameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void aspectSet(long MAtomicTypeId, PersistentMAspect aspectVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MAtmcTpFacade.aspctSet(?, ?, ?); end;");
            callable.setLong(1, MAtomicTypeId);
            callable.setLong(2, aspectVal.getId());
            callable.setLong(3, aspectVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void superTypeSet(long MAtomicTypeId, PersistentMAtomicType superTypeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MAtmcTpFacade.sprTpSet(?, ?, ?); end;");
            callable.setLong(1, MAtomicTypeId);
            callable.setLong(2, superTypeVal.getId());
            callable.setLong(3, superTypeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long MAtomicTypeId, PersistentMAtomicType ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MAtmcTpFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, MAtomicTypeId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public MAtomicTypeSearchList inverseGetAspect(long objectId, long classId)throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MAtmcTpFacade.iGetAspct(?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, objectId);
            callable.setLong(3, classId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            MAtomicTypeSearchList result = new MAtomicTypeSearchList();
            while (list.next()) {
                if (list.getLong(3) != 0) result.add((PersistentMAtomicType)PersistentProxi.createProxi(list.getLong(3), list.getLong(4)));
                else result.add((PersistentMAtomicType)PersistentProxi.createProxi(list.getLong(1), list.getLong(2)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public MAtomicTypeSearchList inverseGetSuperType(long objectId, long classId)throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MAtmcTpFacade.iGetSprTp(?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, objectId);
            callable.setLong(3, classId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            MAtomicTypeSearchList result = new MAtomicTypeSearchList();
            while (list.next()) {
                if (list.getLong(3) != 0) result.add((PersistentMAtomicType)PersistentProxi.createProxi(list.getLong(3), list.getLong(4)));
                else result.add((PersistentMAtomicType)PersistentProxi.createProxi(list.getLong(1), list.getLong(2)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

