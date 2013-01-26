package persistence;

import model.quantity.*;

import java.sql.*;
import oracle.jdbc.*;

public class ReferenceFacade{

	private String schemaName;
	private Connection con;

	public ReferenceFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public ReferenceProxi newReference(long exponent,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".RfrncFacade.newRfrnc(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, exponent);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Reference result = new Reference(null,exponent,null,null,id);
            Cache.getTheCache().put(result);
            return (ReferenceProxi)PersistentProxi.createProxi(id, 180);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ReferenceProxi newDelayedReference(long exponent) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".RfrncFacade.newDelayedRfrnc(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Reference result = new Reference(null,exponent,null,null,id);
            Cache.getTheCache().put(result);
            return (ReferenceProxi)PersistentProxi.createProxi(id, 180);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Reference getReference(long ReferenceId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".RfrncFacade.getRfrnc(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, ReferenceId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentReferenceType type = null;
            if (obj.getLong(2) != 0)
                type = (PersistentReferenceType)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentUnit ref = null;
            if (obj.getLong(5) != 0)
                ref = (PersistentUnit)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            PersistentReference This = null;
            if (obj.getLong(7) != 0)
                This = (PersistentReference)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            Reference result = new Reference(type,
                                             obj.getLong(4),
                                             ref,
                                             This,
                                             ReferenceId);
            obj.close();
            callable.close();
            ReferenceICProxi inCache = (ReferenceICProxi)Cache.getTheCache().put(result);
            Reference objectInCache = (Reference)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".RfrncFacade.getClass(?); end;");
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
    public void typeSet(long ReferenceId, PersistentReferenceType typeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RfrncFacade.tpSet(?, ?, ?); end;");
            callable.setLong(1, ReferenceId);
            callable.setLong(2, typeVal.getId());
            callable.setLong(3, typeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void exponentSet(long ReferenceId, long exponentVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RfrncFacade.expnntSet(?, ?); end;");
            callable.setLong(1, ReferenceId);
            callable.setLong(2, exponentVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void refSet(long ReferenceId, PersistentUnit refVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RfrncFacade.rfSet(?, ?, ?); end;");
            callable.setLong(1, ReferenceId);
            callable.setLong(2, refVal.getId());
            callable.setLong(3, refVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long ReferenceId, PersistentReference ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RfrncFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, ReferenceId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

