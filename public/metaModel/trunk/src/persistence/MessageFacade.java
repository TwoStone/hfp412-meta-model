package persistence;

import model.messageOrLink.*;

import java.sql.*;
import oracle.jdbc.*;

public class MessageFacade{

	private String schemaName;
	private Connection con;

	public MessageFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public MessageProxi newMessage(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MssgFacade.newMssg(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Message result = new Message(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (MessageProxi)PersistentProxi.createProxi(id, 135);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MessageProxi newDelayedMessage() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MssgFacade.newDelayedMssg(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Message result = new Message(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (MessageProxi)PersistentProxi.createProxi(id, 135);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Message getMessage(long MessageId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MssgFacade.getMssg(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, MessageId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentInstanceObject source = null;
            if (obj.getLong(2) != 0)
                source = (PersistentInstanceObject)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentInstanceObject target = null;
            if (obj.getLong(4) != 0)
                target = (PersistentInstanceObject)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentMessageOrLink This = null;
            if (obj.getLong(6) != 0)
                This = (PersistentMessageOrLink)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentOperation type = null;
            if (obj.getLong(8) != 0)
                type = (PersistentOperation)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            Message result = new Message(source,
                                         target,
                                         This,
                                         type,
                                         MessageId);
            obj.close();
            callable.close();
            MessageICProxi inCache = (MessageICProxi)Cache.getTheCache().put(result);
            Message objectInCache = (Message)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void typeSet(long MessageId, PersistentOperation typeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MssgFacade.tpSet(?, ?, ?); end;");
            callable.setLong(1, MessageId);
            callable.setLong(2, typeVal.getId());
            callable.setLong(3, typeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long actualParametersAdd(long MessageId, PersistentActualParameter actualParametersVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MssgFacade.actlPrmtrsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, MessageId);
            callable.setLong(3, actualParametersVal.getId());
            callable.setLong(4, actualParametersVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void actualParametersRem(long actualParametersId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MssgFacade.actlPrmtrsRem(?); end;");
            callable.setLong(1, actualParametersId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public ActualParameterList actualParametersGet(long MessageId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MssgFacade.actlPrmtrsGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, MessageId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            ActualParameterList result = new ActualParameterList();
            while (list.next()) {
                result.add((PersistentActualParameter)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

