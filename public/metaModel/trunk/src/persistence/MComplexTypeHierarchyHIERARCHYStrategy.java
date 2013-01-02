package persistence;


/* Additional import section end */

public interface MComplexTypeHierarchyHIERARCHYStrategy<T> {
    
    public T finalize$$MAtomicType(final PersistentMAtomicType ths, final T parameter) 
				throws PersistenceException;
    public T finalize$$MEmptySum(final PersistentMEmptySum ths, final T parameter, final T containedTypes) 
				throws PersistenceException;
    public T initialize$$MProductType$$containedTypes(final PersistentMProductType ths, final T parameter) 
				throws PersistenceException;
    public T initialize$$MSumType$$containedTypes(final PersistentMSumType ths, final T parameter) 
				throws PersistenceException;
    public T finalize$$MProductType(final PersistentMProductType ths, final T parameter, final T containedTypes) 
				throws PersistenceException;
    public T initialize$$MEmptySum$$containedTypes(final PersistentMEmptySum ths, final T parameter) 
				throws PersistenceException;
    public T initialize$$MEmptyProduct$$containedTypes(final PersistentMEmptyProduct ths, final T parameter) 
				throws PersistenceException;
    public T consolidate$$MEmptyProduct$$containedTypes(final PersistentMEmptyProduct ths, final T result, final T current) 
				throws PersistenceException;
    public T finalize$$MEmptyProduct(final PersistentMEmptyProduct ths, final T parameter, final T containedTypes) 
				throws PersistenceException;
    public T finalize$$MSumType(final PersistentMSumType ths, final T parameter, final T containedTypes) 
				throws PersistenceException;
    public T consolidate$$MSumType$$containedTypes(final PersistentMSumType ths, final T result, final T current) 
				throws PersistenceException;
    public T consolidate$$MEmptySum$$containedTypes(final PersistentMEmptySum ths, final T result, final T current) 
				throws PersistenceException;
    public T consolidate$$MProductType$$containedTypes(final PersistentMProductType ths, final T result, final T current) 
				throws PersistenceException;

    
}

