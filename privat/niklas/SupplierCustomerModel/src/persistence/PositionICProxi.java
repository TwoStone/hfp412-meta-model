package persistence;



public class PositionICProxi extends PersistentInCacheProxiOptimistic implements PersistentPosition{
    
    public PositionICProxi(long objectId) {
        super(objectId);
    }
    public PositionICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().thePositionFacade
            .getPosition(this.getId());
    }
    
    public long getClassId() {
        return 115;
    }
    
    public PersistentProduct getProduct() throws PersistenceException {
        return ((PersistentPosition)this.getTheObject()).getProduct();
    }
    public void setProduct(PersistentProduct newValue) throws PersistenceException {
        ((PersistentPosition)this.getTheObject()).setProduct(newValue);
    }
    public long getQuantity() throws PersistenceException {
        return ((PersistentPosition)this.getTheObject()).getQuantity();
    }
    public void setQuantity(long newValue) throws PersistenceException {
        ((PersistentPosition)this.getTheObject()).setQuantity(newValue);
    }
    public PersistentPosition getThis() throws PersistenceException {
        return ((PersistentPosition)this.getTheObject()).getThis();
    }
    
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handlePosition(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handlePosition(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handlePosition(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handlePosition(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentPosition)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentPosition)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentPosition)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentPosition)this.getTheObject()).initializeOnCreation();
    }

    
}
