package persistence;



import java.sql.*;
import oracle.jdbc.*;

public class ComposedMetaTypeFacade{

	private String schemaName;
	private Connection con;

	public ComposedMetaTypeFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public long componentsAdd(long ComposedMetaTypeId, PersistentAbstractMetaType componentsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpsdMtTpFacade.cmpnntsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, ComposedMetaTypeId);
            callable.setLong(3, componentsVal.getId());
            callable.setLong(4, componentsVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void componentsRem(long componentsId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CmpsdMtTpFacade.cmpnntsRem(?); end;");
            callable.setLong(1, componentsId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public AbstractMetaTypeList componentsGet(long ComposedMetaTypeId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpsdMtTpFacade.cmpnntsGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, ComposedMetaTypeId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            AbstractMetaTypeList result = new AbstractMetaTypeList();
            while (list.next()) {
                result.add((PersistentAbstractMetaType)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

