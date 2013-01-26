package persistence;

import model.messageOrLink.*;

import java.sql.*;
import oracle.jdbc.*;

public class LinkFacade{

	private String schemaName;
	private Connection con;

	public LinkFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public LinkProxi newLink(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".LnkFacade.newLnk(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Link result = new Link(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (LinkProxi)PersistentProxi.createProxi(id, 141);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public LinkProxi newDelayedLink() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".LnkFacade.newDelayedLnk(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Link result = new Link(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (LinkProxi)PersistentProxi.createProxi(id, 141);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Link getLink(long LinkId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".LnkFacade.getLnk(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, LinkId);
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
            PersistentAssociation type = null;
            if (obj.getLong(8) != 0)
                type = (PersistentAssociation)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            Link result = new Link(source,
                                   target,
                                   This,
                                   type,
                                   LinkId);
            obj.close();
            callable.close();
            LinkICProxi inCache = (LinkICProxi)Cache.getTheCache().put(result);
            Link objectInCache = (Link)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void typeSet(long LinkId, PersistentAssociation typeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".LnkFacade.tpSet(?, ?, ?); end;");
            callable.setLong(1, LinkId);
            callable.setLong(2, typeVal.getId());
            callable.setLong(3, typeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

