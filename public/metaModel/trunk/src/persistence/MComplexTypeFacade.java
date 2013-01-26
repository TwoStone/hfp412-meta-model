package persistence;



import java.sql.*;
import oracle.jdbc.*;

public class MComplexTypeFacade{

	private String schemaName;
	private Connection con;

	public MComplexTypeFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public long containedTypesAdd(long MComplexTypeId, PersistentMType containedTypesVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MCmplxTpFacade.cntndTpsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, MComplexTypeId);
            callable.setLong(3, containedTypesVal.getId());
            callable.setLong(4, containedTypesVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void containedTypesRem(long containedTypesId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MCmplxTpFacade.cntndTpsRem(?); end;");
            callable.setLong(1, containedTypesId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public MTypeList containedTypesGet(long MComplexTypeId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MCmplxTpFacade.cntndTpsGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, MComplexTypeId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            MTypeList result = new MTypeList();
            while (list.next()) {
                result.add((PersistentMType)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

