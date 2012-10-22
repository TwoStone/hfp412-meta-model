package persistence;



public class OrderProxi extends PersistentProxi implements PersistentOrder{
    
    public OrderProxi(long objectId) {
        super(objectId);
    }
    public OrderProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theOrderFacade
            .getOrder(this.getId());
    }
    
    public long getClassId() {
        return 106;
    }
    
    public PersistentCustomer getCustomer() throws PersistenceException {
        return ((PersistentOrder)this.getTheObject()).getCustomer();
    }
    public void setCustomer(PersistentCustomer newValue) throws PersistenceException {
        ((PersistentOrder)this.getTheObject()).setCustomer(newValue);
    }
    public PersistentSupplier getSupplier() throws PersistenceException {
        return ((PersistentOrder)this.getTheObject()).getSupplier();
    }
    public void setSupplier(PersistentSupplier newValue) throws PersistenceException {
        ((PersistentOrder)this.getTheObject()).setSupplier(newValue);
    }
    public Order_PositionsProxi getPositions() throws PersistenceException {
        return ((PersistentOrder)this.getTheObject()).getPositions();
    }
    public long getOrderId() throws PersistenceException {
        return ((PersistentOrder)this.getTheObject()).getOrderId();
    }
    public void setOrderId(long newValue) throws PersistenceException {
        ((PersistentOrder)this.getTheObject()).setOrderId(newValue);
    }
    public PersistentOrder getThis() throws PersistenceException {
        return ((PersistentOrder)this.getTheObject()).getThis();
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
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentOrder)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentOrder)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentOrder)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentOrder)this.getTheObject()).initializeOnCreation();
    }
    public void addPosition(final PersistentProduct product, final long quanitity) 
				throws PersistenceException{
        ((PersistentOrder)this.getTheObject()).addPosition(product, quanitity);
    }

    
}
