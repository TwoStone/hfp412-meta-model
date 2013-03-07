
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentMAbstractTypeConjunction;
import persistence.PersistentMEmptyTypeConjunction;
import persistence.PersistentMMixedConjunction;
import persistence.PersistentMNonEmptyAtomicTypeConjunction;

public abstract class MAbstractTypeConjunctionStandardVisitor implements MAbstractTypeConjunctionVisitor {
    
    public void handleMNonEmptyAtomicTypeConjunction(PersistentMNonEmptyAtomicTypeConjunction mNonEmptyAtomicTypeConjunction) throws PersistenceException{
        this.standardHandling(mNonEmptyAtomicTypeConjunction);
    }
    public void handleMEmptyTypeConjunction(PersistentMEmptyTypeConjunction mEmptyTypeConjunction) throws PersistenceException{
        this.standardHandling(mEmptyTypeConjunction);
    }
    public void handleMMixedConjunction(PersistentMMixedConjunction mMixedConjunction) throws PersistenceException{
        this.standardHandling(mMixedConjunction);
    }
    protected abstract void standardHandling(PersistentMAbstractTypeConjunction mAbstractTypeConjunction) throws PersistenceException;
}
