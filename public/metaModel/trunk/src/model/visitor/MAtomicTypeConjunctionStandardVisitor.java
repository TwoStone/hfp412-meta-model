
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentMAtomicTypeConjunction;
import persistence.PersistentMEmptyTypeConjunction;
import persistence.PersistentMNonEmptyAtomicTypeConjunction;

public abstract class MAtomicTypeConjunctionStandardVisitor implements MAtomicTypeConjunctionVisitor {
    
    public void handleMEmptyTypeConjunction(PersistentMEmptyTypeConjunction mEmptyTypeConjunction) throws PersistenceException{
        this.standardHandling(mEmptyTypeConjunction);
    }
    public void handleMNonEmptyAtomicTypeConjunction(PersistentMNonEmptyAtomicTypeConjunction mNonEmptyAtomicTypeConjunction) throws PersistenceException{
        this.standardHandling(mNonEmptyAtomicTypeConjunction);
    }
    protected abstract void standardHandling(PersistentMAtomicTypeConjunction mAtomicTypeConjunction) throws PersistenceException;
}
