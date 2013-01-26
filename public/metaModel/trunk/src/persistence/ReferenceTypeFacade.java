package persistence;

import model.quantity.*;

import java.sql.*;
import oracle.jdbc.*;

public class ReferenceTypeFacade{

	private String schemaName;
	private Connection con;

	public ReferenceTypeFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public ReferenceTypeProxi newReferenceType(long exponent,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".RfrncTpFacade.newRfrncTp(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, exponent);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ReferenceType result = new ReferenceType(exponent,null,null,id);
            Cache.getTheCache().put(result);
            return (ReferenceTypeProxi)PersistentProxi.createProxi(id, 182);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ReferenceTypeProxi newDelayedReferenceType(long exponent) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".RfrncTpFacade.newDelayedRfrncTp(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ReferenceType result = new ReferenceType(exponent,null,null,id);
            Cache.getTheCache().put(result);
            return (ReferenceTypeProxi)PersistentProxi.createProxi(id, 182);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ReferenceType getReferenceType(long ReferenceTypeId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".RfrncTpFacade.getRfrncTp(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, ReferenceTypeId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentUnitType ref = null;
            if (obj.getLong(3) != 0)
                ref = (PersistentUnitType)PersistentProxi.createProxi(obj.getLong(3), obj.getLong(4));
            PersistentReferenceType This = null;
            if (obj.getLong(5) != 0)
                This = (PersistentReferenceType)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            ReferenceType result = new ReferenceType(obj.getLong(2),
                                                     ref,
                                                     This,
                                                     ReferenceTypeId);
            obj.close();
            callable.close();
            ReferenceTypeICProxi inCache = (ReferenceTypeICProxi)Cache.getTheCache().put(result);
            ReferenceType objectInCache = (ReferenceType)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".RfrncTpFacade.getClass(?); end;");
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
    public void exponentSet(long ReferenceTypeId, long exponentVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RfrncTpFacade.expnntSet(?, ?); end;");
            callable.setLong(1, ReferenceTypeId);
            callable.setLong(2, exponentVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void refSet(long ReferenceTypeId, PersistentUnitType refVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RfrncTpFacade.rfSet(?, ?, ?); end;");
            callable.setLong(1, ReferenceTypeId);
            callable.setLong(2, refVal.getId());
            callable.setLong(3, refVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long ReferenceTypeId, PersistentReferenceType ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RfrncTpFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, ReferenceTypeId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

