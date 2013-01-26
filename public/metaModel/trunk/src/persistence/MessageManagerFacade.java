package persistence;

import model.messageOrLink.*;

import java.sql.*;
import oracle.jdbc.*;

public class MessageManagerFacade{

	private String schemaName;
	private Connection con;

	public MessageManagerFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public MessageManagerProxi getTheMessageManager() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MssgMngrFacade.getTheMssgMngr; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (MessageManagerProxi)PersistentProxi.createProxi(id, 170);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MessageManager getMessageManager(long MessageManagerId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MssgMngrFacade.getMssgMngr(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, MessageManagerId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentMessageManager This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentMessageManager)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            MessageManager result = new MessageManager(This,
                                                       MessageManagerId);
            obj.close();
            callable.close();
            MessageManagerICProxi inCache = (MessageManagerICProxi)Cache.getTheCache().put(result);
            MessageManager objectInCache = (MessageManager)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MssgMngrFacade.getClass(?); end;");
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
    public long messagesAdd(long MessageManagerId, PersistentMessage messagesVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MssgMngrFacade.mssgsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, MessageManagerId);
            callable.setLong(3, messagesVal.getId());
            callable.setLong(4, messagesVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void messagesRem(long messagesId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MssgMngrFacade.mssgsRem(?); end;");
            callable.setLong(1, messagesId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public MessageList messagesGet(long MessageManagerId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MssgMngrFacade.mssgsGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, MessageManagerId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            MessageList result = new MessageList();
            while (list.next()) {
                result.add((PersistentMessage)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long MessageManagerId, PersistentMessageManager ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MssgMngrFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, MessageManagerId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

