package persistence;



import java.sql.*;
import oracle.jdbc.*;

public class QuantifObjectFacade{

	private String schemaName;
	private Connection con;

	public QuantifObjectFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".QntfObjctFacade.getClass(?); end;");
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
    public void objectSet(long QuantifObjectId, PersistentInstanceObject objectVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".QntfObjctFacade.objctSet(?, ?, ?); end;");
            callable.setLong(1, QuantifObjectId);
            callable.setLong(2, objectVal.getId());
            callable.setLong(3, objectVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long QuantifObjectId, PersistentQuantifObject ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".QntfObjctFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, QuantifObjectId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public QuantifObjectSearchList inverseGetObject(long objectId, long classId)throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".QntfObjctFacade.iGetObjct(?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, objectId);
            callable.setLong(3, classId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            QuantifObjectSearchList result = new QuantifObjectSearchList();
            while (list.next()) {
                if (list.getLong(3) != 0) result.add((PersistentQuantifObject)PersistentProxi.createProxi(list.getLong(3), list.getLong(4)));
                else result.add((PersistentQuantifObject)PersistentProxi.createProxi(list.getLong(1), list.getLong(2)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

