package persistence;

import model.visitor.*;
import model.*;


/* Additional import section end */

public interface MCTypeHierarchyHIERARCHY extends AbstractPersistentProxi {
    
    public boolean containsMCTypeHierarchy(final MCTypeHierarchyHIERARCHY part) 
				throws PersistenceException;
    public <T> T strategyMCTypeHierarchy(final T parameter, final MCTypeHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException;

    public void accept(MCTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException;
    public <R> R accept(MCTypeHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(MCTypeHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(MCTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

