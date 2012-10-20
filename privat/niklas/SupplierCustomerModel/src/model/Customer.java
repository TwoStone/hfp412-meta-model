
package model;

import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.CustomerProxi;
import persistence.OrderSearchList;
import persistence.PersistenceException;
import persistence.PersistentCustomer;
import persistence.PersistentRole;
import persistence.PersistentSupplier;
import persistence.TDObserver;


/* Additional import section end */

public class Customer extends model.Role implements PersistentCustomer{
    
    
    public static PersistentCustomer createCustomer() throws PersistenceException {
        PersistentCustomer result = ConnectionHandler.getTheConnectionHandler().theCustomerFacade
            .newCustomer();
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentCustomer createCustomer(PersistentCustomer This) throws PersistenceException {
        PersistentCustomer result = ConnectionHandler.getTheConnectionHandler().theCustomerFacade
            .newCustomer();
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("myOrders", this.getMyOrders(tdObserver).getVector(allResults, (depth > 1 ? depth : depth + 1), essentialLevel, forGUI, tdObserver));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Customer provideCopy() throws PersistenceException{
        Customer result = this;
        result = new Customer(this.This, 
                              this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public Customer(PersistentRole This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentRole)This,id);        
    }
    
    static public long getTypeId() {
        return 101;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public PersistentCustomer getThis() throws PersistenceException {
        if(this.This == null){
            PersistentCustomer result = new CustomerProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentCustomer)this.This;
    }
    
    public void accept(model.visitor.RoleVisitor visitor) throws PersistenceException {
        visitor.handleCustomer(this);
    }
    public <R> R accept(model.visitor.RoleReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCustomer(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.RoleExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCustomer(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.RoleReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCustomer(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCustomer(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCustomer(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCustomer(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCustomer(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + this.getMyOrders().getLength());
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
	}
    public void createOrder(final PersistentSupplier supplier) 
				throws PersistenceException{
		Order.createOrder(this.getThis(), supplier);
	}
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
	}
    public OrderSearchList getMyOrders(final TDObserver observer) 
				throws PersistenceException{
        OrderSearchList result = getThis().getMyOrders();
		observer.updateTransientDerived(getThis(), "myOrders", result);
		return result;
    }
    public OrderSearchList inverseGetCustomer() 
				throws PersistenceException{
        OrderSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theOrderFacade
							.inverseGetCustomer(this.getId(), this.getClassId());
		return result;
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentCustomer)This);
		if(this.equals(This)){
		}
    }
    public OrderSearchList getMyOrders() 
				throws PersistenceException{
		return this.inverseGetCustomer();
	}
    public void initializeOnCreation() 
				throws PersistenceException{
	}

    /* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */
    
}
