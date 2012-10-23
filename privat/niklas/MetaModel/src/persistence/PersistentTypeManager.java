package persistence;

public interface PersistentTypeManager extends Anything, AbstractPersistentProxi {
    
    public TypeManager_AllTypesProxi getAllTypes() throws PersistenceException ;
    public PersistentTypeManager getThis() throws PersistenceException ;
    
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void createType(final String name, final PersistentMetaAspect aspect, final Invoker invoker) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void createType(final String name, final PersistentMetaAspect aspect) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;

}

