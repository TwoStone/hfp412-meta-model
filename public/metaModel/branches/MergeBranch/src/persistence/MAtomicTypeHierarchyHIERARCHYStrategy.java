package persistence;


/* Additional import section end */

public interface MAtomicTypeHierarchyHIERARCHYStrategy<T> {
    
    public T initialize$$MAtomicType$$superType(final PersistentMAtomicType ths, final T parameter) 
				throws PersistenceException;
    public T finalize$$MAtomicType(final PersistentMAtomicType ths, final T parameter, final T superType) 
				throws PersistenceException;

    
}

