
package model;

import persistence.*;


/* Additional import section end */

public class Customer extends model.Role implements PersistentCustomer{
    
    
    public static PersistentCustomer createCustomer(PersistentActor roleFor) throws PersistenceException {
        PersistentCustomer result = ConnectionHandler.getTheConnectionHandler().theCustomerFacade
            .newCustomer();
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("roleFor", roleFor);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentCustomer createCustomer(PersistentActor roleFor,PersistentCustomer This) throws PersistenceException {
        PersistentCustomer result = ConnectionHandler.getTheConnectionHandler().theCustomerFacade
            .newCustomer();
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("roleFor", roleFor);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Customer provideCopy() throws PersistenceException{
        Customer result = this;
        result = new Customer(this.roleFor, 
                              this.This, 
                              this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public Customer(PersistentActor roleFor,PersistentRole This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentActor)roleFor,(PersistentRole)This,id);        
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
        return 0;
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentCustomer)This);
		if(this.equals(This)){
			this.setRoleFor((PersistentActor)final$$Fields.get("roleFor"));
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
