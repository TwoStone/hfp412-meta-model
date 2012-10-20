
package model;

import persistence.*;


/* Additional import section end */

public class Order extends PersistentObject implements PersistentOrder{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentOrder getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theOrderFacade.getClass(objectId);
        return (PersistentOrder)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentOrder createOrder(PersistentCustomer customer,PersistentSupplier supplier) throws PersistenceException {
        PersistentOrder result = ConnectionHandler.getTheConnectionHandler().theOrderFacade
            .newOrder();
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("customer", customer);
        final$$Fields.put("supplier", supplier);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentOrder createOrder(PersistentCustomer customer,PersistentSupplier supplier,PersistentOrder This) throws PersistenceException {
        PersistentOrder result = ConnectionHandler.getTheConnectionHandler().theOrderFacade
            .newOrder();
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("customer", customer);
        final$$Fields.put("supplier", supplier);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot customer = (AbstractPersistentRoot)this.getCustomer();
            if (customer != null) {
                result.put("customer", customer.createProxiInformation());
                if(depth > 1) {
                    customer.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && customer.hasEssentialFields())customer.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot supplier = (AbstractPersistentRoot)this.getSupplier();
            if (supplier != null) {
                result.put("supplier", supplier.createProxiInformation());
                if(depth > 1) {
                    supplier.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && supplier.hasEssentialFields())supplier.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            result.put("positions", this.getPositions().getVector(allResults, depth, essentialLevel, forGUI, tdObserver));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Order provideCopy() throws PersistenceException{
        Order result = this;
        result = new Order(this.customer, 
                           this.supplier, 
                           this.This, 
                           this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentCustomer customer;
    protected PersistentSupplier supplier;
    protected Order_PositionsProxi positions;
    protected PersistentOrder This;
    
    public Order(PersistentCustomer customer,PersistentSupplier supplier,PersistentOrder This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.customer = customer;
        this.supplier = supplier;
        this.positions = new Order_PositionsProxi(this);
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 106;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public PersistentCustomer getCustomer() throws PersistenceException {
        return this.customer;
    }
    public void setCustomer(PersistentCustomer newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.customer)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.customer = (PersistentCustomer)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theOrderFacade.customerSet(this.getId(), newValue);
    }
    public PersistentSupplier getSupplier() throws PersistenceException {
        return this.supplier;
    }
    public void setSupplier(PersistentSupplier newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.supplier)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.supplier = (PersistentSupplier)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theOrderFacade.supplierSet(this.getId(), newValue);
    }
    public Order_PositionsProxi getPositions() throws PersistenceException {
        return this.positions;
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
            + this.getPositions().getLength());
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{        
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{        
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentOrder)This);
		if(this.equals(This)){
			this.setCustomer((PersistentCustomer)final$$Fields.get("customer"));
			this.setSupplier((PersistentSupplier)final$$Fields.get("supplier"));
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{        
    }
    public void addPosition(final PersistentProduct product, final long quanitity) 
				throws PersistenceException{
    	this.getThis().getPositions().add(Position.createPosition(product, quanitity));
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
