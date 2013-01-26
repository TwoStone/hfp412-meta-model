package persistence;

import model.typeSystem.*;

import java.sql.*;
import oracle.jdbc.*;

public class MEmptyProductTypeFacade{

	private String schemaName;
	private Connection con;

	public MEmptyProductTypeFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public MEmptyProductTypeProxi getTheMEmptyProductType() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MEmptProdFacade.getTheMEmptProd; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (MEmptyProductTypeProxi)PersistentProxi.createProxi(id, 238);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MEmptyProductType getMEmptyProductType(long MEmptyProductTypeId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MEmptProdFacade.getMEmptProd(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, MEmptyProductTypeId);
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
            MEmptyProductType result = new MEmptyProductType(This,
                                                             MEmptyProductTypeId);
            obj.close();
            callable.close();
            MEmptyProductTypeICProxi inCache = (MEmptyProductTypeICProxi)Cache.getTheCache().put(result);
            MEmptyProductType objectInCache = (MEmptyProductType)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

