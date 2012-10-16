package persistence;



public class OrderICProxi extends PersistentInCacheProxiOptimistic implements PersistentOrder{
    
    public OrderICProxi(long objectId) {
        super(objectId);
    }
    public OrderICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theOrderFacade
            .getOrder(this.getId());
    }
    
    public long getClassId() {
        return 117;
    }
    
    public PersistentPosition getPosition() throws PersistenceException {
        return ((PersistentOrder)this.getTheObject()).getPosition();
    }
    public void setPosition(PersistentPosition newValue) throws PersistenceException {
        ((PersistentOrder)this.getTheObject()).setPosition(newValue);
    }
    public PersistentCustomer getCustomer() throws PersistenceException {
        return ((PersistentOrder)this.getTheObject()).getCustomer();
    }
    public void setCustomer(PersistentCustomer newValue) throws PersistenceException {
        ((PersistentOrder)this.getTheObject()).setCustomer(newValue);
    }
    public PersistentSupplier getContractor() throws PersistenceException {
        return ((PersistentOrder)this.getTheObject()).getContractor();
    }
    public void setContractor(PersistentSupplier newValue) throws PersistenceException {
        ((PersistentOrder)this.getTheObject()).setContractor(newValue);
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

    
}
