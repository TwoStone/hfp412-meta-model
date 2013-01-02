package persistence;

import model.quantity.*;

import java.sql.*;
import oracle.jdbc.*;

public class QuantityFacade{

	private String schemaName;
	private Connection con;

	public QuantityFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public QuantityProxi newQuantity(common.Fraction amount,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".QnttFacade.newQntt(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, amount.toString());
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Quantity result = new Quantity(null,amount,null,id);
            Cache.getTheCache().put(result);
            return (QuantityProxi)PersistentProxi.createProxi(id, 157);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public QuantityProxi newDelayedQuantity(common.Fraction amount) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".QnttFacade.newDelayedQntt(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Quantity result = new Quantity(null,amount,null,id);
            Cache.getTheCache().put(result);
            return (QuantityProxi)PersistentProxi.createProxi(id, 157);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Quantity getQuantity(long QuantityId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".QnttFacade.getQntt(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, QuantityId);
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
            PersistentUnit unit = null;
            if (obj.getLong(5) != 0)
                unit = (PersistentUnit)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            Quantity result = new Quantity(This,
                                           common.Fraction.parse(obj.getString(4)),
                                           unit,
                                           QuantityId);
            obj.close();
            callable.close();
            QuantityICProxi inCache = (QuantityICProxi)Cache.getTheCache().put(result);
            Quantity objectInCache = (Quantity)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void amountSet(long QuantityId, common.Fraction amountVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".QnttFacade.amntSet(?, ?); end;");
            callable.setLong(1, QuantityId);
            callable.setString(2, amountVal.toString());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void unitSet(long QuantityId, PersistentUnit unitVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".QnttFacade.untSet(?, ?, ?); end;");
            callable.setLong(1, QuantityId);
            callable.setLong(2, unitVal.getId());
            callable.setLong(3, unitVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

