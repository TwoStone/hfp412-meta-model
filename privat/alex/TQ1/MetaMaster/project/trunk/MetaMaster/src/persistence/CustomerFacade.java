package persistence;

import model.*;

public class CustomerFacade{



	public CustomerFacade() {
	}

    public CustomerProxi newCustomer() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theRoleFacade.getNextId();
        Customer result = new Customer(null,null,id);
        Cache.getTheCache().put(result);
        return (CustomerProxi)PersistentProxi.createProxi(id, 101);
    }
    
    public Customer getCustomer(long CustomerId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

