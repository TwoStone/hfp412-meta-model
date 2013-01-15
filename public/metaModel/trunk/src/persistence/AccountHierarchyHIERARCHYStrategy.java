package persistence;


/* Additional import section end */

public interface AccountHierarchyHIERARCHYStrategy<T> {
    
    public T consolidate$$Account$$subAccounts(final PersistentAccount ths, final T result, final T current) 
				throws PersistenceException;
    public T initialize$$Account$$subAccounts(final PersistentAccount ths, final T parameter) 
				throws PersistenceException;
    public T finalize$$Account(final PersistentAccount ths, final T parameter, final T subAccounts) 
				throws PersistenceException;

    
}

