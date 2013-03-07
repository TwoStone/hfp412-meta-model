
package model.visitor;

import persistence.*;

public interface MAtomicTypeConjunctionReturnVisitor<R> {
    
    public R handleMNonEmptyAtomicTypeConjunction(PersistentMNonEmptyAtomicTypeConjunction mNonEmptyAtomicTypeConjunction) throws PersistenceException;
    public R handleMEmptyTypeConjunction(PersistentMEmptyTypeConjunction mEmptyTypeConjunction) throws PersistenceException;
    
}
