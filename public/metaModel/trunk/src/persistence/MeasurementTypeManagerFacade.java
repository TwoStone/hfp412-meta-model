package persistence;

import model.measurement.*;

import java.sql.*;
import oracle.jdbc.*;

public class MeasurementTypeManagerFacade{

	private String schemaName;
	private Connection con;

	public MeasurementTypeManagerFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public MeasurementTypeManagerProxi getTheMeasurementTypeManager() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MsrmntTpMngFacade.getTheMsrmntTpMng; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (MeasurementTypeManagerProxi)PersistentProxi.createProxi(id, 186);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MeasurementTypeManager getMeasurementTypeManager(long MeasurementTypeManagerId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MsrmntTpMngFacade.getMsrmntTpMng(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, MeasurementTypeManagerId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentMeasurementTypeManager This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentMeasurementTypeManager)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            MeasurementTypeManager result = new MeasurementTypeManager(This,
                                                                       MeasurementTypeManagerId);
            obj.close();
            callable.close();
            MeasurementTypeManagerICProxi inCache = (MeasurementTypeManagerICProxi)Cache.getTheCache().put(result);
            MeasurementTypeManager objectInCache = (MeasurementTypeManager)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MsrmntTpMngFacade.getClass(?); end;");
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
    public long measurementTypesAdd(long MeasurementTypeManagerId, PersistentMMeasurementType measurementTypesVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MsrmntTpMngFacade.msrmntTpsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, MeasurementTypeManagerId);
            callable.setLong(3, measurementTypesVal.getId());
            callable.setLong(4, measurementTypesVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void measurementTypesRem(long measurementTypesId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MsrmntTpMngFacade.msrmntTpsRem(?); end;");
            callable.setLong(1, measurementTypesId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public MMeasurementTypeList measurementTypesGet(long MeasurementTypeManagerId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MsrmntTpMngFacade.msrmntTpsGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, MeasurementTypeManagerId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            MMeasurementTypeList result = new MMeasurementTypeList();
            while (list.next()) {
                result.add((PersistentMMeasurementType)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long MeasurementTypeManagerId, PersistentMeasurementTypeManager ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MsrmntTpMngFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, MeasurementTypeManagerId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

