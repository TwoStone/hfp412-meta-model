
package model.visitor;

import persistence.*;

public abstract class MAbstractTypeConjunctionDirectVisitor implements MAbstractTypeConjunctionVisitor {
    
    public abstract void handleMAtomicTypeConjunction(PersistentMAtomicTypeConjunction mAtomicTypeConjunction) throws PersistenceException;
    
    public void handleMEmptyTypeConjunction(PersistentMEmptyTypeConjunction mEmptyTypeConjunction) throws PersistenceException{
        this.handleMAtomicTypeConjunction(mEmptyTypeConjunction);
    }
    public void handleMNonEmptyAtomicTypeConjunction(PersistentMNonEmptyAtomicTypeConjunction mNonEmptyAtomicTypeConjunction) throws PersistenceException{
        this.handleMAtomicTypeConjunction(mNonEmptyAtomicTypeConjunction);
    }
    public abstract void handleMMixedConjunction(PersistentMMixedConjunction mMixedConjunction) throws PersistenceException;
    
    
}
