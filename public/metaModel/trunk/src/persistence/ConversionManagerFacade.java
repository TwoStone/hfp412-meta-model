package persistence;

import model.quantity.*;

import java.sql.*;
import oracle.jdbc.*;

public class ConversionManagerFacade{

	private String schemaName;
	private Connection con;

	public ConversionManagerFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public ConversionManagerProxi getTheConversionManager() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CnvrsnMngrFacade.getTheCnvrsnMngr; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (ConversionManagerProxi)PersistentProxi.createProxi(id, 149);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ConversionManager getConversionManager(long ConversionManagerId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CnvrsnMngrFacade.getCnvrsnMngr(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, ConversionManagerId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentConversionManager This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentConversionManager)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            ConversionManager result = new ConversionManager(This,
                                                             ConversionManagerId);
            obj.close();
            callable.close();
            ConversionManagerICProxi inCache = (ConversionManagerICProxi)Cache.getTheCache().put(result);
            ConversionManager objectInCache = (ConversionManager)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CnvrsnMngrFacade.getClass(?); end;");
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
    public long conversionsAdd(long ConversionManagerId, PersistentConversion conversionsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CnvrsnMngrFacade.cnvrsnsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, ConversionManagerId);
            callable.setLong(3, conversionsVal.getId());
            callable.setLong(4, conversionsVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void conversionsRem(long conversionsId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CnvrsnMngrFacade.cnvrsnsRem(?); end;");
            callable.setLong(1, conversionsId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public ConversionList conversionsGet(long ConversionManagerId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CnvrsnMngrFacade.cnvrsnsGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, ConversionManagerId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            ConversionList result = new ConversionList();
            while (list.next()) {
                result.add((PersistentConversion)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long ConversionManagerId, PersistentConversionManager ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CnvrsnMngrFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, ConversionManagerId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

