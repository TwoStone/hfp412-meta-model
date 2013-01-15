package persistence;

import model.visitor.*;
import model.*;


/* Additional import section end */

public interface AccountHierarchyHIERARCHY extends AbstractPersistentProxi {
    
    public boolean containsAccountHierarchy(final AccountHierarchyHIERARCHY part) 
				throws PersistenceException;
    public <T> T strategyAccountHierarchy(final T parameter, final AccountHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException;

    public void accept(AccountHierarchyHIERARCHYVisitor visitor) throws PersistenceException;
    public <R> R accept(AccountHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AccountHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AccountHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

