package persistence;

import model.typeSystem.*;

import java.sql.*;
import oracle.jdbc.*;

public class MAtomicTypeFacade{

	private String schemaName;
	private Connection con;

	public MAtomicTypeFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public MAtomicTypeProxi newMAtomicType(String name,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MAtmcTpFacade.newMAtmcTp(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            MAtomicType result = new MAtomicType(null,name,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (MAtomicTypeProxi)PersistentProxi.createProxi(id, 113);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MAtomicTypeProxi newDelayedMAtomicType(String name) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MAtmcTpFacade.newDelayedMAtmcTp(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            MAtomicType result = new MAtomicType(null,name,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (MAtomicTypeProxi)PersistentProxi.createProxi(id, 113);
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
            PersistentMType This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentMType)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentMBoolean singletonType = null;
            if (obj.getLong(5) != 0)
                singletonType = (PersistentMBoolean)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            PersistentMBoolean abstractType = null;
            if (obj.getLong(7) != 0)
                abstractType = (PersistentMBoolean)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            PersistentMAspect aspect = null;
            if (obj.getLong(9) != 0)
                aspect = (PersistentMAspect)PersistentProxi.createProxi(obj.getLong(9), obj.getLong(10));
            PersistentMAtomicType superType = null;
            if (obj.getLong(11) != 0)
                superType = (PersistentMAtomicType)PersistentProxi.createProxi(obj.getLong(11), obj.getLong(12));
            MAtomicType result = new MAtomicType(This,
                                                 obj.getString(4) == null ? "" : obj.getString(4) /* In Oracle "" = null !!! */,
                                                 singletonType,
                                                 abstractType,
                                                 aspect,
                                                 superType,
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
    public void singletonTypeSet(long MAtomicTypeId, PersistentMBoolean singletonTypeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MAtmcTpFacade.sngltnTpSet(?, ?, ?); end;");
            callable.setLong(1, MAtomicTypeId);
            callable.setLong(2, singletonTypeVal.getId());
            callable.setLong(3, singletonTypeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void abstractTypeSet(long MAtomicTypeId, PersistentMBoolean abstractTypeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MAtmcTpFacade.abstrctTpSet(?, ?, ?); end;");
            callable.setLong(1, MAtomicTypeId);
            callable.setLong(2, abstractTypeVal.getId());
            callable.setLong(3, abstractTypeVal.getClassId());
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

