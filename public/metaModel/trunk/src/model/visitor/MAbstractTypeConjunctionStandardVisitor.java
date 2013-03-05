
package model.visitor;

import persistence.*;

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
