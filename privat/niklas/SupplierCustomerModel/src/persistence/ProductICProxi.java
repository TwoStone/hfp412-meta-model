package persistence;



public class ProductICProxi extends PersistentInCacheProxiOptimistic implements PersistentProduct{
    
    public ProductICProxi(long objectId) {
        super(objectId);
    }
    public ProductICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theProductFacade
            .getProduct(this.getId());
    }
    
    public long getClassId() {
        return 105;
    }
    
    public String getName() throws PersistenceException {
        return ((PersistentProduct)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentProduct)this.getTheObject()).setName(newValue);
    }
    public PersistentSupplier getProducer() throws PersistenceException {
        return ((PersistentProduct)this.getTheObject()).getProducer();
    }
    public void setProducer(PersistentSupplier newValue) throws PersistenceException {
        ((PersistentProduct)this.getTheObject()).setProducer(newValue);
    }
    public PersistentProduct getThis() throws PersistenceException {
        return ((PersistentProduct)this.getTheObject()).getThis();
    }
    
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleProduct(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProduct(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProduct(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleProduct(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentProduct)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentProduct)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public String producerAsString() 
				throws PersistenceException{
        return ((PersistentProduct)this.getTheObject()).producerAsString();
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentProduct)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentProduct)this.getTheObject()).initializeOnCreation();
    }

    
}