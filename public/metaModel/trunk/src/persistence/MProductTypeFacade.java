package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class MProductTypeFacade{

	private String schemaName;
	private Connection con;

	public MProductTypeFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public MProductTypeProxi newMProductType(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MPrdctTpFacade.newMPrdctTp(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            MProductType result = new MProductType(null,id);
            Cache.getTheCache().put(result);
            return (MProductTypeProxi)PersistentProxi.createProxi(id, 101);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MProductTypeProxi newDelayedMProductType() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MPrdctTpFacade.newDelayedMPrdctTp(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            MProductType result = new MProductType(null,id);
            Cache.getTheCache().put(result);
            return (MProductTypeProxi)PersistentProxi.createProxi(id, 101);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MProductType getMProductType(long MProductTypeId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MPrdctTpFacade.getMPrdctTp(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, MProductTypeId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentMComplexType This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentMComplexType)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            MProductType result = new MProductType(This,
                                                   MProductTypeId);
            obj.close();
            callable.close();
            MProductTypeICProxi inCache = (MProductTypeICProxi)Cache.getTheCache().put(result);
            MProductType objectInCache = (MProductType)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

