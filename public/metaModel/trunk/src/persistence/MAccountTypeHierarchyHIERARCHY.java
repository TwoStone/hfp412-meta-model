package persistence;

import model.visitor.*;
import model.*;


/* Additional import section end */

public interface MAccountTypeHierarchyHIERARCHY extends AbstractPersistentProxi {
    
    public boolean containsMAccountTypeHierarchy(final MAccountTypeHierarchyHIERARCHY part) 
				throws PersistenceException;
    public <T> T strategyMAccountTypeHierarchy(final T parameter, final MAccountTypeHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException;

    public void accept(MAccountTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException;
    public <R> R accept(MAccountTypeHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(MAccountTypeHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(MAccountTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

