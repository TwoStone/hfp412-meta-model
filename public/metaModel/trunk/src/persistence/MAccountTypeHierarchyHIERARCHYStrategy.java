package persistence;


/* Additional import section end */

public interface MAccountTypeHierarchyHIERARCHYStrategy<T> {
    
    public T finalize$$MAccountType(final PersistentMAccountType ths, final T parameter, final T subAccountTypes) 
				throws PersistenceException;
    public T consolidate$$MAccountType$$subAccountTypes(final PersistentMAccountType ths, final T result, final T current) 
				throws PersistenceException;
    public T initialize$$MAccountType$$subAccountTypes(final PersistentMAccountType ths, final T parameter) 
				throws PersistenceException;

    
}

