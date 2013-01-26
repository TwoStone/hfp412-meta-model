package persistence;

import model.measurement.*;

import java.sql.*;
import oracle.jdbc.*;

public class MMeasurementTypeFacade{

	private String schemaName;
	private Connection con;

	public MMeasurementTypeFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public MMeasurementTypeProxi newMMeasurementType(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MMsrmntTpFacade.newMMsrmntTp(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            MMeasurementType result = new MMeasurementType(null,null,null,id);
            Cache.getTheCache().put(result);
            return (MMeasurementTypeProxi)PersistentProxi.createProxi(id, 126);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MMeasurementTypeProxi newDelayedMMeasurementType() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MMsrmntTpFacade.newDelayedMMsrmntTp(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            MMeasurementType result = new MMeasurementType(null,null,null,id);
            Cache.getTheCache().put(result);
            return (MMeasurementTypeProxi)PersistentProxi.createProxi(id, 126);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MMeasurementType getMMeasurementType(long MMeasurementTypeId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MMsrmntTpFacade.getMMsrmntTp(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, MMeasurementTypeId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentMType type = null;
            if (obj.getLong(2) != 0)
                type = (PersistentMType)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentAbsUnitType unitType = null;
            if (obj.getLong(4) != 0)
                unitType = (PersistentAbsUnitType)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentMQuantiObjectType This = null;
            if (obj.getLong(6) != 0)
                This = (PersistentMQuantiObjectType)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            MMeasurementType result = new MMeasurementType(type,
                                                           unitType,
                                                           This,
                                                           MMeasurementTypeId);
            obj.close();
            callable.close();
            MMeasurementTypeICProxi inCache = (MMeasurementTypeICProxi)Cache.getTheCache().put(result);
            MMeasurementType objectInCache = (MMeasurementType)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

