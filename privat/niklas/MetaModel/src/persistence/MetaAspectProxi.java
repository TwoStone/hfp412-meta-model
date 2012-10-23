package persistence;



public class MetaAspectProxi extends NamedEntityProxi implements PersistentMetaAspect{
    
    public MetaAspectProxi(long objectId) {
        super(objectId);
    }
    public MetaAspectProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theMetaAspectFacade
            .getMetaAspect(this.getId());
    }
    
    public long getClassId() {
        return 119;
    }
    
    public PersistentMetaAspect getThis() throws PersistenceException {
        return ((PersistentMetaAspect)this.getTheObject()).getThis();
    }
    
    public void accept(model.visitor.NamedEntityVisitor visitor) throws PersistenceException {
        visitor.handleMetaAspect(this);
    }
    public <R> R accept(model.visitor.NamedEntityReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMetaAspect(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.NamedEntityExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMetaAspect(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.NamedEntityReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMetaAspect(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMetaAspect(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMetaAspect(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMetaAspect(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMetaAspect(this);
    }
    
    
    public MetaTypeSearchList getTypes(final TDObserver observer) 
				throws PersistenceException{
        return ((PersistentMetaAspect)this.getTheObject()).getTypes(observer);
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMetaAspect)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMetaAspect)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public MetaTypeSearchList getTypes() 
				throws PersistenceException{
        return ((PersistentMetaAspect)this.getTheObject()).getTypes();
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMetaAspect)this.getTheObject()).initialize(This, final$$Fields);
    }
    public MetaTypeSearchList inverseGetMyAspect() 
				throws PersistenceException{
        return ((PersistentMetaAspect)this.getTheObject()).inverseGetMyAspect();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMetaAspect)this.getTheObject()).initializeOnCreation();
    }

    
}
