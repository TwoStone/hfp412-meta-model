package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class MetaTypeFacade{

	private String schemaName;
	private Connection con;

	public MetaTypeFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public MetaTypeProxi newMetaType() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MtTpFacade.newMtTp; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            MetaType result = new MetaType(null,null,null,id);
            Cache.getTheCache().put(result);
            return (MetaTypeProxi)PersistentProxi.createProxi(id, 122);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MetaType getMetaType(long MetaTypeId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MtTpFacade.getMtTp(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, MetaTypeId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentAbstractMetaType This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentAbstractMetaType)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentMetaAspect myAspect = null;
            if (obj.getLong(4) != 0)
                myAspect = (PersistentMetaAspect)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentNamedEntity myCONCNamedEntity = null;
            if (obj.getLong(6) != 0)
                myCONCNamedEntity = (PersistentNamedEntity)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            MetaType result = new MetaType(This,
                                           myAspect,
                                           myCONCNamedEntity,
                                           MetaTypeId);
            obj.close();
            callable.close();
            MetaTypeICProxi inCache = (MetaTypeICProxi)Cache.getTheCache().put(result);
            MetaType objectInCache = (MetaType)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long subtypesAdd(long MetaTypeId, PersistentMetaType subtypesVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MtTpFacade.sbtpsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, MetaTypeId);
            callable.setLong(3, subtypesVal.getId());
            callable.setLong(4, subtypesVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subtypesRem(long subtypesId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MtTpFacade.sbtpsRem(?); end;");
            callable.setLong(1, subtypesId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public MetaTypeList subtypesGet(long MetaTypeId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MtTpFacade.sbtpsGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, MetaTypeId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            MetaTypeList result = new MetaTypeList();
            while (list.next()) {
                result.add((PersistentMetaType)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myAspectSet(long MetaTypeId, PersistentMetaAspect myAspectVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MtTpFacade.mAspctSet(?, ?, ?); end;");
            callable.setLong(1, MetaTypeId);
            callable.setLong(2, myAspectVal.getId());
            callable.setLong(3, myAspectVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCONCNamedEntitySet(long MetaTypeId, PersistentNamedEntity myCONCNamedEntityVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MtTpFacade.myCONCNmdEnttSet(?, ?, ?); end;");
            callable.setLong(1, MetaTypeId);
            callable.setLong(2, myCONCNamedEntityVal.getId());
            callable.setLong(3, myCONCNamedEntityVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public MetaTypeSearchList inverseGetSubtypes(long objectId, long classId)throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MtTpFacade.iGetSbtps(?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, objectId);
            callable.setLong(3, classId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            MetaTypeSearchList result = new MetaTypeSearchList();
            while (list.next()) {
                if (list.getLong(3) != 0) result.add((PersistentMetaType)PersistentProxi.createProxi(list.getLong(3), list.getLong(4)));
                else result.add((PersistentMetaType)PersistentProxi.createProxi(list.getLong(1), list.getLong(2)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public MetaTypeSearchList inverseGetMyAspect(long objectId, long classId)throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MtTpFacade.iGetMAspct(?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, objectId);
            callable.setLong(3, classId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            MetaTypeSearchList result = new MetaTypeSearchList();
            while (list.next()) {
                if (list.getLong(3) != 0) result.add((PersistentMetaType)PersistentProxi.createProxi(list.getLong(3), list.getLong(4)));
                else result.add((PersistentMetaType)PersistentProxi.createProxi(list.getLong(1), list.getLong(2)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

