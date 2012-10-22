package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class OrderFacade{

	private String schemaName;
	private Connection con;

	public OrderFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public OrderProxi newOrder(long orderId) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".OrdrFacade.newOrdr(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, orderId);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Order result = new Order(null,null,orderId,null,id);
            Cache.getTheCache().put(result);
            return (OrderProxi)PersistentProxi.createProxi(id, 106);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Order getOrder(long OrderId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".OrdrFacade.getOrdr(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, OrderId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentCustomer customer = null;
            if (obj.getLong(2) != 0)
                customer = (PersistentCustomer)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentSupplier supplier = null;
            if (obj.getLong(4) != 0)
                supplier = (PersistentSupplier)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentOrder This = null;
            if (obj.getLong(7) != 0)
                This = (PersistentOrder)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            Order result = new Order(customer,
                                     supplier,
                                     obj.getLong(6),
                                     This,
                                     OrderId);
            obj.close();
            callable.close();
            OrderICProxi inCache = (OrderICProxi)Cache.getTheCache().put(result);
            Order objectInCache = (Order)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".OrdrFacade.getClass(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, objectId);
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void customerSet(long OrderId, PersistentCustomer customerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".OrdrFacade.cstmrSet(?, ?, ?); end;");
            callable.setLong(1, OrderId);
            callable.setLong(2, customerVal.getId());
            callable.setLong(3, customerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void supplierSet(long OrderId, PersistentSupplier supplierVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".OrdrFacade.spplrSet(?, ?, ?); end;");
            callable.setLong(1, OrderId);
            callable.setLong(2, supplierVal.getId());
            callable.setLong(3, supplierVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long positionsAdd(long OrderId, PersistentPosition positionsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".OrdrFacade.pstnsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, OrderId);
            callable.setLong(3, positionsVal.getId());
            callable.setLong(4, positionsVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void positionsRem(long positionsId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".OrdrFacade.pstnsRem(?); end;");
            callable.setLong(1, positionsId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public PositionList positionsGet(long OrderId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".OrdrFacade.pstnsGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, OrderId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            PositionList result = new PositionList();
            while (list.next()) {
                result.add((PersistentPosition)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void orderIdSet(long OrderId, long orderIdVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".OrdrFacade.ordrIdSet(?, ?); end;");
            callable.setLong(1, OrderId);
            callable.setLong(2, orderIdVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long OrderId, PersistentOrder ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".OrdrFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, OrderId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public OrderSearchList inverseGetCustomer(long objectId, long classId)throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".OrdrFacade.iGetCstmr(?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, objectId);
            callable.setLong(3, classId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            OrderSearchList result = new OrderSearchList();
            while (list.next()) {
                if (list.getLong(3) != 0) result.add((PersistentOrder)PersistentProxi.createProxi(list.getLong(3), list.getLong(4)));
                else result.add((PersistentOrder)PersistentProxi.createProxi(list.getLong(1), list.getLong(2)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

