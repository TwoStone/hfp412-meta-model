package persistence;



public class TypeManagerICProxi extends PersistentInCacheProxiOptimistic implements PersistentTypeManager{
    
    public TypeManagerICProxi(long objectId) {
        super(objectId);
    }
    public TypeManagerICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theTypeManagerFacade
            .getTypeManager(this.getId());
    }
    
    public long getClassId() {
        return 129;
    }
    
    public TypeManager_AllTypesProxi getAllTypes() throws PersistenceException {
        return ((PersistentTypeManager)this.getTheObject()).getAllTypes();
    }
    public PersistentTypeManager getThis() throws PersistenceException {
        return ((PersistentTypeManager)this.getTheObject()).getThis();
    }
    
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleTypeManager(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTypeManager(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTypeManager(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTypeManager(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentTypeManager)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentTypeManager)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void createType(final String name, final PersistentMetaAspect aspect, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentTypeManager)this.getTheObject()).createType(name, aspect, invoker);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentTypeManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void createType(final String name, final PersistentMetaAspect aspect) 
				throws PersistenceException{
        ((PersistentTypeManager)this.getTheObject()).createType(name, aspect);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentTypeManager)this.getTheObject()).initializeOnCreation();
    }

    
}
