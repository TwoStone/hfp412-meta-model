package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class SupplierFacade{

	private String schemaName;
	private Connection con;

	public SupplierFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public SupplierProxi newSupplier() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".SpplrFacade.newSpplr; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Supplier result = new Supplier(null,id);
            Cache.getTheCache().put(result);
            return (SupplierProxi)PersistentProxi.createProxi(id, 110);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Supplier getSupplier(long SupplierId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".SpplrFacade.getSpplr(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, SupplierId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentRole This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentRole)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            Supplier result = new Supplier(This,
                                           SupplierId);
            obj.close();
            callable.close();
            SupplierICProxi inCache = (SupplierICProxi)Cache.getTheCache().put(result);
            Supplier objectInCache = (Supplier)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

