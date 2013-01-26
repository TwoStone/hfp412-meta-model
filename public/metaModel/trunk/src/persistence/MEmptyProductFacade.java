package persistence;

import model.typeSystem.*;

import java.sql.*;
import oracle.jdbc.*;

public class MEmptyProductFacade{

	private String schemaName;
	private Connection con;

	public MEmptyProductFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public MEmptyProductProxi getTheMEmptyProduct() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MEmptPrdctFacade.getTheMEmptPrdct; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (MEmptyProductProxi)PersistentProxi.createProxi(id, 108);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MEmptyProduct getMEmptyProduct(long MEmptyProductId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MEmptPrdctFacade.getMEmptPrdct(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, MEmptyProductId);
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
            MEmptyProduct result = new MEmptyProduct(This,
                                                     MEmptyProductId);
            obj.close();
            callable.close();
            MEmptyProductICProxi inCache = (MEmptyProductICProxi)Cache.getTheCache().put(result);
            MEmptyProduct objectInCache = (MEmptyProduct)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

