package persistence;

public interface PersistentMProductType extends PersistentMComplexType {
    
    public PersistentMProductType getThis() throws PersistenceException ;
    
    public void accept(model.visitor.MComplexTypeVisitor visitor) throws PersistenceException;
    public <R> R accept(model.visitor.MComplexTypeReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(model.visitor.MComplexTypeExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(model.visitor.MComplexTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(model.visitor.MTypeVisitor visitor) throws PersistenceException;
    public <R> R accept(model.visitor.MTypeReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(model.visitor.MTypeExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(model.visitor.MTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(model.visitor.MCTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException;
    public <R> R accept(model.visitor.MCTypeHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(model.visitor.MCTypeHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(model.visitor.MCTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public boolean containsMCTypeHierarchy(final MCTypeHierarchyHIERARCHY part) 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public <T> T strategyMCTypeHierarchy(final T parameter, final MCTypeHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;

}

