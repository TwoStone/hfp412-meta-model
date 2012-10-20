package persistence;

public interface PersistentMetaAssociation extends PersistentNamedEntity {
    
    public PersistentAbstractMetaType getFromType() throws PersistenceException ;
    public void setFromType(PersistentAbstractMetaType newValue) throws PersistenceException ;
    public PersistentAbstractMetaType getToType() throws PersistenceException ;
    public void setToType(PersistentAbstractMetaType newValue) throws PersistenceException ;
    public MetaAssociation_HierarchiesProxi getHierarchies() throws PersistenceException ;
    public PersistentMetaAssociation getThis() throws PersistenceException ;
    
    public void accept(model.visitor.NamedEntityVisitor visitor) throws PersistenceException;
    public <R> R accept(model.visitor.NamedEntityReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(model.visitor.NamedEntityExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(model.visitor.NamedEntityReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;

}

