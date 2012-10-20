package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class CustomerFacade{

	private String schemaName;
	private Connection con;

	public CustomerFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CustomerProxi newCustomer() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CstmrFacade.newCstmr; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Customer result = new Customer(null,id);
            Cache.getTheCache().put(result);
            return (CustomerProxi)PersistentProxi.createProxi(id, 101);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Customer getCustomer(long CustomerId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CstmrFacade.getCstmr(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CustomerId);
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
            Customer result = new Customer(This,
                                           CustomerId);
            obj.close();
            callable.close();
            CustomerICProxi inCache = (CustomerICProxi)Cache.getTheCache().put(result);
            Customer objectInCache = (Customer)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

