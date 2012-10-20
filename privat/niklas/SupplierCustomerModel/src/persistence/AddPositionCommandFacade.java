package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class AddPositionCommandFacade{

	private String schemaName;
	private Connection con;

	public AddPositionCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public AddPositionCommandProxi newAddPositionCommand(long quanitity) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AddPstnCMDFacade.newAddPstnCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, quanitity);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AddPositionCommand result = new AddPositionCommand(null,null,quanitity,null,null,null,id);
            Cache.getTheCache().put(result);
            return (AddPositionCommandProxi)PersistentProxi.createProxi(id, 128);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AddPositionCommand getAddPositionCommand(long AddPositionCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AddPstnCMDFacade.getAddPstnCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AddPositionCommandId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentOrder order = null;
            if (obj.getLong(2) != 0)
                order = (PersistentOrder)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentProduct product = null;
            if (obj.getLong(4) != 0)
                product = (PersistentProduct)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            Invoker invoker = null;
            if (obj.getLong(7) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            PersistentActorManager commandReceiver = null;
            if (obj.getLong(9) != 0)
                commandReceiver = (PersistentActorManager)PersistentProxi.createProxi(obj.getLong(9), obj.getLong(10));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(11) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(11), obj.getLong(12));
            AddPositionCommand result = new AddPositionCommand(order,
                                                               product,
                                                               obj.getLong(6),
                                                               invoker,
                                                               commandReceiver,
                                                               myCommonDate,
                                                               AddPositionCommandId);
            obj.close();
            callable.close();
            AddPositionCommandICProxi inCache = (AddPositionCommandICProxi)Cache.getTheCache().put(result);
            AddPositionCommand objectInCache = (AddPositionCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AddPstnCMDFacade.getClass(?); end;");
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
    public void orderSet(long AddPositionCommandId, PersistentOrder orderVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddPstnCMDFacade.ordrSet(?, ?, ?); end;");
            callable.setLong(1, AddPositionCommandId);
            callable.setLong(2, orderVal.getId());
            callable.setLong(3, orderVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void productSet(long AddPositionCommandId, PersistentProduct productVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddPstnCMDFacade.prdctSet(?, ?, ?); end;");
            callable.setLong(1, AddPositionCommandId);
            callable.setLong(2, productVal.getId());
            callable.setLong(3, productVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void quanititySet(long AddPositionCommandId, long quanitityVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddPstnCMDFacade.qnttSet(?, ?); end;");
            callable.setLong(1, AddPositionCommandId);
            callable.setLong(2, quanitityVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long AddPositionCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddPstnCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, AddPositionCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long AddPositionCommandId, PersistentActorManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddPstnCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, AddPositionCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long AddPositionCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddPstnCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, AddPositionCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

