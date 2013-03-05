
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentMEmptyTypeConjunction;
import persistence.PersistentMNonEmptyAtomicTypeConjunction;

public interface MAtomicTypeConjunctionReturnVisitor<R> {
    
    public R handleMNonEmptyAtomicTypeConjunction(PersistentMNonEmptyAtomicTypeConjunction mNonEmptyAtomicTypeConjunction) throws PersistenceException;
    public R handleMEmptyTypeConjunction(PersistentMEmptyTypeConjunction mEmptyTypeConjunction) throws PersistenceException;
    
}
