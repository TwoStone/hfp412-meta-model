
package model;

import persistence.*;


/* Additional import section end */

public class Order extends PersistentObject implements PersistentOrder{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentOrder getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theOrderFacade.getClass(objectId);
        return (PersistentOrder)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentOrder createOrder(PersistentPosition position,PersistentCustomer customer,PersistentSupplier contractor) throws PersistenceException {
        PersistentOrder result = ConnectionHandler.getTheConnectionHandler().theOrderFacade
            .newOrder();
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("position", position);
        final$$Fields.put("customer", customer);
        final$$Fields.put("contractor", contractor);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        if(result.getThis().getPosition() == null)throw new PersistenceException("Field position in type Order has not been initialized!",0);
        if(result.getThis().getCustomer() == null)throw new PersistenceException("Field customer in type Order has not been initialized!",0);
        if(result.getThis().getContractor() == null)throw new PersistenceException("Field contractor in type Order has not been initialized!",0);
        return result;
    }
    
    public static PersistentOrder createOrder(PersistentPosition position,PersistentCustomer customer,PersistentSupplier contractor,PersistentOrder This) throws PersistenceException {
        PersistentOrder result = ConnectionHandler.getTheConnectionHandler().theOrderFacade
            .newOrder();
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("position", position);
        final$$Fields.put("customer", customer);
        final$$Fields.put("contractor", contractor);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot position = (AbstractPersistentRoot)this.getPosition();
            if (position != null) {
                result.put("position", position.createProxiInformation());
                if(depth > 1) {
                    position.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && position.hasEssentialFields())position.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot customer = (AbstractPersistentRoot)this.getCustomer();
            if (customer != null) {
                result.put("customer", customer.createProxiInformation());
                if(depth > 1) {
                    customer.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && customer.hasEssentialFields())customer.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot contractor = (AbstractPersistentRoot)this.getContractor();
            if (contractor != null) {
                result.put("contractor", contractor.createProxiInformation());
                if(depth > 1) {
                    contractor.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && contractor.hasEssentialFields())contractor.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Order provideCopy() throws PersistenceException{
        Order result = this;
        result = new Order(this.position, 
                           this.customer, 
                           this.contractor, 
                           this.This, 
                           this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentPosition position;
    protected PersistentCustomer customer;
    protected PersistentSupplier contractor;
    protected PersistentOrder This;
    
    public Order(PersistentPosition position,PersistentCustomer customer,PersistentSupplier contractor,PersistentOrder This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.position = position;
        this.customer = customer;
        this.contractor = contractor;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 117;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public PersistentPosition getPosition() throws PersistenceException {
        return this.position;
    }
    public void setPosition(PersistentPosition newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.position)) return;
        if(getThis().getPosition() != null)throw new PersistenceException("Final field position in type Order has been set already!",0);
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.position = (PersistentPosition)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theOrderFacade.positionSet(this.getId(), newValue);
    }
    public PersistentCustomer getCustomer() throws PersistenceException {
        return this.customer;
    }
    public void setCustomer(PersistentCustomer newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.customer)) return;
        if(getThis().getCustomer() != null)throw new PersistenceException("Final field customer in type Order has been set already!",0);
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.customer = (PersistentCustomer)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theOrderFacade.customerSet(this.getId(), newValue);
    }
    public PersistentSupplier getContractor() throws PersistenceException {
        return this.contractor;
    }
    public void setContractor(PersistentSupplier newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.contractor)) return;
        if(getThis().getContractor() != null)throw new PersistenceException("Final field contractor in type Order has been set already!",0);
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.contractor = (PersistentSupplier)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theOrderFacade.contractorSet(this.getId(), newValue);
    }
    protected void setThis(PersistentOrder newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentOrder)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theOrderFacade.ThisSet(this.getId(), newValue);
    }
    public PersistentOrder getThis() throws PersistenceException {
        if(this.This == null){
            PersistentOrder result = new OrderProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentOrder)this.This;
    }
    
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleOrder(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleOrder(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleOrder(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleOrder(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + (this.getPosition() == null ? 0 : 1)
            + (this.getCustomer() == null ? 0 : 1)
            + (this.getContractor() == null ? 0 : 1));
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
        this.setThis((PersistentOrder)This);
		if(this.equals(This)){
			this.setPosition((PersistentPosition)final$$Fields.get("position"));
			this.setCustomer((PersistentCustomer)final$$Fields.get("customer"));
			this.setContractor((PersistentSupplier)final$$Fields.get("contractor"));
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
