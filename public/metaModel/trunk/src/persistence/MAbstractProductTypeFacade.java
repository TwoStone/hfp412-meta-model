package persistence;

import model.typeSystem.*;

import java.sql.*;
import oracle.jdbc.*;

public class MAbstractProductTypeFacade{

	private String schemaName;
	private Connection con;

	public MAbstractProductTypeFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public MAbstractProductTypeProxi newMAbstractProductType(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MAbstrProdFacade.newMAbstrProd(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            MAbstractProductType result = new MAbstractProductType(null,id);
            Cache.getTheCache().put(result);
            return (MAbstractProductTypeProxi)PersistentProxi.createProxi(id, 136);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MAbstractProductTypeProxi newDelayedMAbstractProductType() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MAbstrProdFacade.newDelayedMAbstrProd(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            MAbstractProductType result = new MAbstractProductType(null,id);
            Cache.getTheCache().put(result);
            return (MAbstractProductTypeProxi)PersistentProxi.createProxi(id, 136);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MAbstractProductType getMAbstractProductType(long MAbstractProductTypeId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MAbstrProdFacade.getMAbstrProd(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, MAbstractProductTypeId);
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
            MAbstractProductType result = new MAbstractProductType(This,
                                                                   MAbstractProductTypeId);
            obj.close();
            callable.close();
            MAbstractProductTypeICProxi inCache = (MAbstractProductTypeICProxi)Cache.getTheCache().put(result);
            MAbstractProductType objectInCache = (MAbstractProductType)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

