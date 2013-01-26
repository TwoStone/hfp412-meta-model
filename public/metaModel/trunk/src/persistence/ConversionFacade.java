package persistence;

import model.quantity.*;

import java.sql.*;
import oracle.jdbc.*;

public class ConversionFacade{

	private String schemaName;
	private Connection con;

	public ConversionFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public ConversionProxi newConversion(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CnvrsnFacade.newCnvrsn(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Conversion result = new Conversion(null,null,null,id);
            Cache.getTheCache().put(result);
            return (ConversionProxi)PersistentProxi.createProxi(id, 179);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ConversionProxi newDelayedConversion() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CnvrsnFacade.newDelayedCnvrsn(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Conversion result = new Conversion(null,null,null,id);
            Cache.getTheCache().put(result);
            return (ConversionProxi)PersistentProxi.createProxi(id, 179);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Conversion getConversion(long ConversionId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CnvrsnFacade.getCnvrsn(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, ConversionId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentUnit source = null;
            if (obj.getLong(2) != 0)
                source = (PersistentUnit)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentFunction myFunction = null;
            if (obj.getLong(4) != 0)
                myFunction = (PersistentFunction)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentConversion This = null;
            if (obj.getLong(6) != 0)
                This = (PersistentConversion)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            Conversion result = new Conversion(source,
                                               myFunction,
                                               This,
                                               ConversionId);
            obj.close();
            callable.close();
            ConversionICProxi inCache = (ConversionICProxi)Cache.getTheCache().put(result);
            Conversion objectInCache = (Conversion)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CnvrsnFacade.getClass(?); end;");
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
    public void sourceSet(long ConversionId, PersistentUnit sourceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CnvrsnFacade.srcSet(?, ?, ?); end;");
            callable.setLong(1, ConversionId);
            callable.setLong(2, sourceVal.getId());
            callable.setLong(3, sourceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myFunctionSet(long ConversionId, PersistentFunction myFunctionVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CnvrsnFacade.mFnctnSet(?, ?, ?); end;");
            callable.setLong(1, ConversionId);
            callable.setLong(2, myFunctionVal.getId());
            callable.setLong(3, myFunctionVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long ConversionId, PersistentConversion ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CnvrsnFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, ConversionId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public ConversionSearchList inverseGetSource(long objectId, long classId)throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CnvrsnFacade.iGetSrc(?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, objectId);
            callable.setLong(3, classId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            ConversionSearchList result = new ConversionSearchList();
            while (list.next()) {
                if (list.getLong(3) != 0) result.add((PersistentConversion)PersistentProxi.createProxi(list.getLong(3), list.getLong(4)));
                else result.add((PersistentConversion)PersistentProxi.createProxi(list.getLong(1), list.getLong(2)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

