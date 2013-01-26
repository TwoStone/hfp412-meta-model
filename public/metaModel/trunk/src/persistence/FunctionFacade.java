package persistence;

import model.quantity.*;

import java.sql.*;
import oracle.jdbc.*;

public class FunctionFacade{

	private String schemaName;
	private Connection con;

	public FunctionFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public FunctionProxi newFunction(common.Fraction factor,common.Fraction constant,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".FnctnFacade.newFnctn(?,?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, factor.toString());
            callable.setString(3, constant.toString());
            callable.setLong(4, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Function result = new Function(factor,constant,null,id);
            Cache.getTheCache().put(result);
            return (FunctionProxi)PersistentProxi.createProxi(id, 137);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public FunctionProxi newDelayedFunction(common.Fraction factor,common.Fraction constant) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".FnctnFacade.newDelayedFnctn(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Function result = new Function(factor,constant,null,id);
            Cache.getTheCache().put(result);
            return (FunctionProxi)PersistentProxi.createProxi(id, 137);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Function getFunction(long FunctionId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".FnctnFacade.getFnctn(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, FunctionId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentFunction This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentFunction)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            Function result = new Function(common.Fraction.parse(obj.getString(2)),
                                           common.Fraction.parse(obj.getString(3)),
                                           This,
                                           FunctionId);
            obj.close();
            callable.close();
            FunctionICProxi inCache = (FunctionICProxi)Cache.getTheCache().put(result);
            Function objectInCache = (Function)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".FnctnFacade.getClass(?); end;");
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
    public void factorSet(long FunctionId, common.Fraction factorVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".FnctnFacade.fctrSet(?, ?); end;");
            callable.setLong(1, FunctionId);
            callable.setString(2, factorVal.toString());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void constantSet(long FunctionId, common.Fraction constantVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".FnctnFacade.cnstntSet(?, ?); end;");
            callable.setLong(1, FunctionId);
            callable.setString(2, constantVal.toString());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long FunctionId, PersistentFunction ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".FnctnFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, FunctionId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

