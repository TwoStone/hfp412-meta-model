package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class MSumTypeFacade{

	private String schemaName;
	private Connection con;

	public MSumTypeFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public MSumTypeProxi newMSumType() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MSmTpFacade.newMSmTp; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            MSumType result = new MSumType(null,id);
            Cache.getTheCache().put(result);
            return (MSumTypeProxi)PersistentProxi.createProxi(id, 103);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MSumType getMSumType(long MSumTypeId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MSmTpFacade.getMSmTp(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, MSumTypeId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentMComplexType This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentMComplexType)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            MSumType result = new MSumType(This,
                                           MSumTypeId);
            obj.close();
            callable.close();
            MSumTypeICProxi inCache = (MSumTypeICProxi)Cache.getTheCache().put(result);
            MSumType objectInCache = (MSumType)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

