
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentMEmptyTypeConjunction;
import persistence.PersistentMNonEmptyAtomicTypeConjunction;

public interface MAtomicTypeConjunctionVisitor {
    
    public void handleMNonEmptyAtomicTypeConjunction(PersistentMNonEmptyAtomicTypeConjunction mNonEmptyAtomicTypeConjunction) throws PersistenceException;
    public void handleMEmptyTypeConjunction(PersistentMEmptyTypeConjunction mEmptyTypeConjunction) throws PersistenceException;
    
}
