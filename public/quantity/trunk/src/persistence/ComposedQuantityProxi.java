package persistence;



public class ComposedQuantityProxi extends AbsQuantityProxi implements PersistentComposedQuantity{
    
    public ComposedQuantityProxi(long objectId) {
        super(objectId);
    }
    public ComposedQuantityProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theComposedQuantityFacade
            .getComposedQuantity(this.getId());
    }
    
    public long getClassId() {
        return 123;
    }
    
    public ComposedQuantity_PartsProxi getParts() throws PersistenceException {
        return ((PersistentComposedQuantity)this.getTheObject()).getParts();
    }
    public PersistentComposedQuantity getThis() throws PersistenceException {
        return ((PersistentComposedQuantity)this.getTheObject()).getThis();
    }
    
    public void accept(model.visitor.AbsQuantityVisitor visitor) throws PersistenceException {
        visitor.handleComposedQuantity(this);
    }
    public <R> R accept(model.visitor.AbsQuantityReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleComposedQuantity(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AbsQuantityExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleComposedQuantity(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AbsQuantityReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleComposedQuantity(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleComposedQuantity(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleComposedQuantity(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleComposedQuantity(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleComposedQuantity(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentComposedQuantity)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentComposedQuantity)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentComposedQuantity)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentComposedQuantity)this.getTheObject()).initializeOnCreation();
    }

    
}
