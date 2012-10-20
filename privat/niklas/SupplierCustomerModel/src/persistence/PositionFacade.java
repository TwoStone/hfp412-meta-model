package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class PositionFacade{

	private String schemaName;
	private Connection con;

	public PositionFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PositionProxi newPosition(long quantity) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".PstnFacade.newPstn(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, quantity);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Position result = new Position(null,quantity,null,id);
            Cache.getTheCache().put(result);
            return (PositionProxi)PersistentProxi.createProxi(id, 115);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Position getPosition(long PositionId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".PstnFacade.getPstn(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, PositionId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentProduct product = null;
            if (obj.getLong(2) != 0)
                product = (PersistentProduct)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentPosition This = null;
            if (obj.getLong(5) != 0)
                This = (PersistentPosition)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            Position result = new Position(product,
                                           obj.getLong(4),
                                           This,
                                           PositionId);
            obj.close();
            callable.close();
            PositionICProxi inCache = (PositionICProxi)Cache.getTheCache().put(result);
            Position objectInCache = (Position)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".PstnFacade.getClass(?); end;");
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
    public void productSet(long PositionId, PersistentProduct productVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".PstnFacade.prdctSet(?, ?, ?); end;");
            callable.setLong(1, PositionId);
            callable.setLong(2, productVal.getId());
            callable.setLong(3, productVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void quantitySet(long PositionId, long quantityVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".PstnFacade.qnttSet(?, ?); end;");
            callable.setLong(1, PositionId);
            callable.setLong(2, quantityVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long PositionId, PersistentPosition ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".PstnFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, PositionId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

