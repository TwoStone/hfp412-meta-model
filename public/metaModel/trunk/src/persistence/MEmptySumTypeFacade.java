package persistence;

import model.typeSystem.*;

import java.sql.*;
import oracle.jdbc.*;

public class MEmptySumTypeFacade{

	private String schemaName;
	private Connection con;

	public MEmptySumTypeFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public MEmptySumTypeProxi getTheMEmptySumType() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MEmptSmTpFacade.getTheMEmptSmTp; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (MEmptySumTypeProxi)PersistentProxi.createProxi(id, 187);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MEmptySumType getMEmptySumType(long MEmptySumTypeId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MEmptSmTpFacade.getMEmptSmTp(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, MEmptySumTypeId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentMType This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentMType)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            MEmptySumType result = new MEmptySumType(This,
                                                     MEmptySumTypeId);
            obj.close();
            callable.close();
            MEmptySumTypeICProxi inCache = (MEmptySumTypeICProxi)Cache.getTheCache().put(result);
            MEmptySumType objectInCache = (MEmptySumType)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

