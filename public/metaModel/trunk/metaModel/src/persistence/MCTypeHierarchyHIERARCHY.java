package persistence;


/* Additional import section end */

public interface MCTypeHierarchyHIERARCHY extends AbstractPersistentProxi {
    
    public boolean containsMCTypeHierarchy(final MCTypeHierarchyHIERARCHY part) 
				throws PersistenceException;
    public <T> T strategyMCTypeHierarchy(final T parameter, final MCTypeHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException;

    public void accept(model.visitor.MCTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException;
    public <R> R accept(model.visitor.MCTypeHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(model.visitor.MCTypeHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(model.visitor.MCTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

