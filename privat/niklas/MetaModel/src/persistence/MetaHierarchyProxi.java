package persistence;



public class MetaHierarchyProxi extends NamedEntityProxi implements PersistentMetaHierarchy{
    
    public MetaHierarchyProxi(long objectId) {
        super(objectId);
    }
    public MetaHierarchyProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theMetaHierarchyFacade
            .getMetaHierarchy(this.getId());
    }
    
    public long getClassId() {
        return 121;
    }
    
    public PersistentMetaHierarchy getThis() throws PersistenceException {
        return ((PersistentMetaHierarchy)this.getTheObject()).getThis();
    }
    
    public void accept(model.visitor.NamedEntityVisitor visitor) throws PersistenceException {
        visitor.handleMetaHierarchy(this);
    }
    public <R> R accept(model.visitor.NamedEntityReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMetaHierarchy(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.NamedEntityExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMetaHierarchy(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.NamedEntityReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMetaHierarchy(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMetaHierarchy(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMetaHierarchy(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMetaHierarchy(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMetaHierarchy(this);
    }
    
    
    public MetaAssociationSearchList inverseGetHierarchies() 
				throws PersistenceException{
        return ((PersistentMetaHierarchy)this.getTheObject()).inverseGetHierarchies();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMetaHierarchy)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMetaHierarchy)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMetaHierarchy)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMetaHierarchy)this.getTheObject()).initializeOnCreation();
    }

    
}
