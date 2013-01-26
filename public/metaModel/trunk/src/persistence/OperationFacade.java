package persistence;

import model.abstractOperation.*;

import java.sql.*;
import oracle.jdbc.*;

public class OperationFacade{

	private String schemaName;
	private Connection con;

	public OperationFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public OperationProxi newOperation(String name,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".OprtnFacade.newOprtn(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Operation result = new Operation(name,null,null,null,id);
            Cache.getTheCache().put(result);
            return (OperationProxi)PersistentProxi.createProxi(id, 148);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public OperationProxi newDelayedOperation(String name) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".OprtnFacade.newDelayedOprtn(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Operation result = new Operation(name,null,null,null,id);
            Cache.getTheCache().put(result);
            return (OperationProxi)PersistentProxi.createProxi(id, 148);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Operation getOperation(long OperationId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".OprtnFacade.getOprtn(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, OperationId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentMType source = null;
            if (obj.getLong(3) != 0)
                source = (PersistentMType)PersistentProxi.createProxi(obj.getLong(3), obj.getLong(4));
            PersistentMType target = null;
            if (obj.getLong(5) != 0)
                target = (PersistentMType)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            PersistentAbsOperation This = null;
            if (obj.getLong(7) != 0)
                This = (PersistentAbsOperation)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            Operation result = new Operation(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                             source,
                                             target,
                                             This,
                                             OperationId);
            obj.close();
            callable.close();
            OperationICProxi inCache = (OperationICProxi)Cache.getTheCache().put(result);
            Operation objectInCache = (Operation)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

