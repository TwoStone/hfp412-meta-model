package persistence;

import model.quantity.*;

import java.sql.*;
import oracle.jdbc.*;

public class CompoundQuantityFacade{

	private String schemaName;
	private Connection con;

	public CompoundQuantityFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CompoundQuantityProxi newCompoundQuantity(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpndQnttFacade.newCmpndQntt(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CompoundQuantity result = new CompoundQuantity(null,id);
            Cache.getTheCache().put(result);
            return (CompoundQuantityProxi)PersistentProxi.createProxi(id, 109);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CompoundQuantityProxi newDelayedCompoundQuantity() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpndQnttFacade.newDelayedCmpndQntt(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CompoundQuantity result = new CompoundQuantity(null,id);
            Cache.getTheCache().put(result);
            return (CompoundQuantityProxi)PersistentProxi.createProxi(id, 109);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CompoundQuantity getCompoundQuantity(long CompoundQuantityId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpndQnttFacade.getCmpndQntt(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CompoundQuantityId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentAbsQuantity This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentAbsQuantity)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            CompoundQuantity result = new CompoundQuantity(This,
                                                           CompoundQuantityId);
            obj.close();
            callable.close();
            CompoundQuantityICProxi inCache = (CompoundQuantityICProxi)Cache.getTheCache().put(result);
            CompoundQuantity objectInCache = (CompoundQuantity)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long partsAdd(long CompoundQuantityId, PersistentQuantity partsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpndQnttFacade.prtsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, CompoundQuantityId);
            callable.setLong(3, partsVal.getId());
            callable.setLong(4, partsVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void partsRem(long partsId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CmpndQnttFacade.prtsRem(?); end;");
            callable.setLong(1, partsId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public QuantityList partsGet(long CompoundQuantityId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpndQnttFacade.prtsGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CompoundQuantityId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            QuantityList result = new QuantityList();
            while (list.next()) {
                result.add((PersistentQuantity)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

