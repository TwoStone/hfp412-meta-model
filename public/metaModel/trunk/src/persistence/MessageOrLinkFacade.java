package persistence;



import java.sql.*;
import oracle.jdbc.*;

public class MessageOrLinkFacade{

	private String schemaName;
	private Connection con;

	public MessageOrLinkFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MssgOrLnkFacade.getClass(?); end;");
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
    public void sourceSet(long MessageOrLinkId, PersistentInstanceObject sourceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MssgOrLnkFacade.srcSet(?, ?, ?); end;");
            callable.setLong(1, MessageOrLinkId);
            callable.setLong(2, sourceVal.getId());
            callable.setLong(3, sourceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void targetSet(long MessageOrLinkId, PersistentInstanceObject targetVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MssgOrLnkFacade.trgtSet(?, ?, ?); end;");
            callable.setLong(1, MessageOrLinkId);
            callable.setLong(2, targetVal.getId());
            callable.setLong(3, targetVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long MessageOrLinkId, PersistentMessageOrLink ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MssgOrLnkFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, MessageOrLinkId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

