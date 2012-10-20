package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class CreateOrderCommandFacade{

	private String schemaName;
	private Connection con;

	public CreateOrderCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CreateOrderCommandProxi newCreateOrderCommand() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtOrdrCMDFacade.newCrtOrdrCMD; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateOrderCommand result = new CreateOrderCommand(null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateOrderCommandProxi)PersistentProxi.createProxi(id, 127);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateOrderCommand getCreateOrderCommand(long CreateOrderCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtOrdrCMDFacade.getCrtOrdrCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CreateOrderCommandId);
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
            Invoker invoker = null;
            if (obj.getLong(6) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentActorManager commandReceiver = null;
            if (obj.getLong(8) != 0)
                commandReceiver = (PersistentActorManager)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(10) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(10), obj.getLong(11));
            CreateOrderCommand result = new CreateOrderCommand(customer,
                                                               supplier,
                                                               invoker,
                                                               commandReceiver,
                                                               myCommonDate,
                                                               CreateOrderCommandId);
            obj.close();
            callable.close();
            CreateOrderCommandICProxi inCache = (CreateOrderCommandICProxi)Cache.getTheCache().put(result);
            CreateOrderCommand objectInCache = (CreateOrderCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtOrdrCMDFacade.getClass(?); end;");
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
    public void customerSet(long CreateOrderCommandId, PersistentCustomer customerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtOrdrCMDFacade.cstmrSet(?, ?, ?); end;");
            callable.setLong(1, CreateOrderCommandId);
            callable.setLong(2, customerVal.getId());
            callable.setLong(3, customerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void supplierSet(long CreateOrderCommandId, PersistentSupplier supplierVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtOrdrCMDFacade.spplrSet(?, ?, ?); end;");
            callable.setLong(1, CreateOrderCommandId);
            callable.setLong(2, supplierVal.getId());
            callable.setLong(3, supplierVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long CreateOrderCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtOrdrCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, CreateOrderCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long CreateOrderCommandId, PersistentActorManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtOrdrCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, CreateOrderCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long CreateOrderCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtOrdrCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, CreateOrderCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

