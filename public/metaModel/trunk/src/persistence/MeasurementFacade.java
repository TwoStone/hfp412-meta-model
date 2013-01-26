package persistence;

import model.measurement.*;

import java.sql.*;
import oracle.jdbc.*;

public class MeasurementFacade{

	private String schemaName;
	private Connection con;

	public MeasurementFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public MeasurementProxi newMeasurement(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MsrmntFacade.newMsrmnt(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Measurement result = new Measurement(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (MeasurementProxi)PersistentProxi.createProxi(id, 116);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MeasurementProxi newDelayedMeasurement() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MsrmntFacade.newDelayedMsrmnt(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Measurement result = new Measurement(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (MeasurementProxi)PersistentProxi.createProxi(id, 116);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Measurement getMeasurement(long MeasurementId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MsrmntFacade.getMsrmnt(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, MeasurementId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentInstanceObject object = null;
            if (obj.getLong(2) != 0)
                object = (PersistentInstanceObject)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentQuantifObject This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentQuantifObject)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentMMeasurementType type = null;
            if (obj.getLong(6) != 0)
                type = (PersistentMMeasurementType)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentAbsQuantity quantity = null;
            if (obj.getLong(8) != 0)
                quantity = (PersistentAbsQuantity)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            Measurement result = new Measurement(object,
                                                 This,
                                                 type,
                                                 quantity,
                                                 MeasurementId);
            obj.close();
            callable.close();
            MeasurementICProxi inCache = (MeasurementICProxi)Cache.getTheCache().put(result);
            Measurement objectInCache = (Measurement)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void typeSet(long MeasurementId, PersistentMMeasurementType typeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MsrmntFacade.tpSet(?, ?, ?); end;");
            callable.setLong(1, MeasurementId);
            callable.setLong(2, typeVal.getId());
            callable.setLong(3, typeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void quantitySet(long MeasurementId, PersistentAbsQuantity quantityVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MsrmntFacade.qnttSet(?, ?, ?); end;");
            callable.setLong(1, MeasurementId);
            callable.setLong(2, quantityVal.getId());
            callable.setLong(3, quantityVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

