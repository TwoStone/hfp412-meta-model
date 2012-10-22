package persistence;



public class CustomerProxi extends RoleProxi implements PersistentCustomer{
    
    public CustomerProxi(long objectId) {
        super(objectId);
    }
    public CustomerProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCustomerFacade
            .getCustomer(this.getId());
    }
    
    public long getClassId() {
        return 101;
    }
    
    public PersistentCustomer getThis() throws PersistenceException {
        return ((PersistentCustomer)this.getTheObject()).getThis();
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
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentCustomer)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentCustomer)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public OrderSearchList inverseGetCustomer() 
				throws PersistenceException{
        return ((PersistentCustomer)this.getTheObject()).inverseGetCustomer();
    }
    public OrderSearchList getMyOrders(final TDObserver observer) 
				throws PersistenceException{
        return ((PersistentCustomer)this.getTheObject()).getMyOrders(observer);
    }
    public OrderSearchList getMyOrders() 
				throws PersistenceException{
        return ((PersistentCustomer)this.getTheObject()).getMyOrders();
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentCustomer)this.getTheObject()).initialize(This, final$$Fields);
    }
    public ActorSearchList inverseGetRoles() 
				throws PersistenceException{
        return ((PersistentCustomer)this.getTheObject()).inverseGetRoles();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentCustomer)this.getTheObject()).initializeOnCreation();
    }
    public void createOrder(final PersistentSupplier supplier, final long orderId) 
				throws PersistenceException{
        ((PersistentCustomer)this.getTheObject()).createOrder(supplier, orderId);
    }

    
}
