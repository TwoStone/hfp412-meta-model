package persistence;



public class OrderItemICProxi extends PersistentInCacheProxiOptimistic implements PersistentOrderItem{
    
    public OrderItemICProxi(long objectId) {
        super(objectId);
    }
    public OrderItemICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theOrderItemFacade
            .getOrderItem(this.getId());
    }
    
    public long getClassId() {
        return 112;
    }
    
    public long getQuantity() throws PersistenceException {
        return ((PersistentOrderItem)this.getTheObject()).getQuantity();
    }
    public void setQuantity(long newValue) throws PersistenceException {
        ((PersistentOrderItem)this.getTheObject()).setQuantity(newValue);
    }
    public PersistentProduct getProduct() throws PersistenceException {
        return ((PersistentOrderItem)this.getTheObject()).getProduct();
    }
    public void setProduct(PersistentProduct newValue) throws PersistenceException {
        ((PersistentOrderItem)this.getTheObject()).setProduct(newValue);
    }
    public PersistentOrderItem getThis() throws PersistenceException {
        return ((PersistentOrderItem)this.getTheObject()).getThis();
    }
    
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleOrderItem(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleOrderItem(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleOrderItem(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleOrderItem(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentOrderItem)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentOrderItem)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentOrderItem)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentOrderItem)this.getTheObject()).initializeOnCreation();
    }

    
}
