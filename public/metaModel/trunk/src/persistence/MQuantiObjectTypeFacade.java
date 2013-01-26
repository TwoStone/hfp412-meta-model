package persistence;



import java.sql.*;
import oracle.jdbc.*;

public class MQuantiObjectTypeFacade{

	private String schemaName;
	private Connection con;

	public MQuantiObjectTypeFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MQntObjctTpFacade.getClass(?); end;");
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
    public void typeSet(long MQuantiObjectTypeId, PersistentMType typeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MQntObjctTpFacade.tpSet(?, ?, ?); end;");
            callable.setLong(1, MQuantiObjectTypeId);
            callable.setLong(2, typeVal.getId());
            callable.setLong(3, typeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void unitTypeSet(long MQuantiObjectTypeId, PersistentAbsUnitType unitTypeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MQntObjctTpFacade.untTpSet(?, ?, ?); end;");
            callable.setLong(1, MQuantiObjectTypeId);
            callable.setLong(2, unitTypeVal.getId());
            callable.setLong(3, unitTypeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long MQuantiObjectTypeId, PersistentMQuantiObjectType ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MQntObjctTpFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, MQuantiObjectTypeId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

