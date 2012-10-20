package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class ProductFacade{

	private String schemaName;
	private Connection con;

	public ProductFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public ProductProxi newProduct(String name) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".PrdctFacade.newPrdct(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Product result = new Product(name,null,null,id);
            Cache.getTheCache().put(result);
            return (ProductProxi)PersistentProxi.createProxi(id, 105);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Product getProduct(long ProductId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".PrdctFacade.getPrdct(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, ProductId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentSupplier producer = null;
            if (obj.getLong(3) != 0)
                producer = (PersistentSupplier)PersistentProxi.createProxi(obj.getLong(3), obj.getLong(4));
            PersistentProduct This = null;
            if (obj.getLong(5) != 0)
                This = (PersistentProduct)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            Product result = new Product(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                         producer,
                                         This,
                                         ProductId);
            obj.close();
            callable.close();
            ProductICProxi inCache = (ProductICProxi)Cache.getTheCache().put(result);
            Product objectInCache = (Product)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".PrdctFacade.getClass(?); end;");
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
    public void nameSet(long ProductId, String nameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".PrdctFacade.nmSet(?, ?); end;");
            callable.setLong(1, ProductId);
            callable.setString(2, nameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void producerSet(long ProductId, PersistentSupplier producerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".PrdctFacade.prdcrSet(?, ?, ?); end;");
            callable.setLong(1, ProductId);
            callable.setLong(2, producerVal.getId());
            callable.setLong(3, producerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long ProductId, PersistentProduct ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".PrdctFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, ProductId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public ProductSearchList inverseGetProducer(long objectId, long classId)throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".PrdctFacade.iGetPrdcr(?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, objectId);
            callable.setLong(3, classId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            ProductSearchList result = new ProductSearchList();
            while (list.next()) {
                if (list.getLong(3) != 0) result.add((PersistentProduct)PersistentProxi.createProxi(list.getLong(3), list.getLong(4)));
                else result.add((PersistentProduct)PersistentProxi.createProxi(list.getLong(1), list.getLong(2)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

