
package model.visitor;

import persistence.*;

public abstract class MComplexTypeDirectVisitor implements MComplexTypeVisitor {
    
    public abstract void handleMAbstractTypeDisjunction(PersistentMAbstractTypeDisjunction mAbstractTypeDisjunction) throws PersistenceException;
    
    public void handleMMixedTypeDisjunction(PersistentMMixedTypeDisjunction mMixedTypeDisjunction) throws PersistenceException{
        this.handleMAbstractTypeDisjunction(mMixedTypeDisjunction);
    }
    public void handleMEmptyTypeDisjunction(PersistentMEmptyTypeDisjunction mEmptyTypeDisjunction) throws PersistenceException{
        this.handleMAbstractTypeDisjunction(mEmptyTypeDisjunction);
    }
    public void handleMNonEmptyDisjunctiveNormalForm(PersistentMNonEmptyDisjunctiveNormalForm mNonEmptyDisjunctiveNormalForm) throws PersistenceException{
        this.handleMAbstractTypeDisjunction(mNonEmptyDisjunctiveNormalForm);
    }
    public abstract void handleMAbstractTypeConjunction(PersistentMAbstractTypeConjunction mAbstractTypeConjunction) throws PersistenceException;
    
    public void handleMNonEmptyAtomicTypeConjunction(PersistentMNonEmptyAtomicTypeConjunction mNonEmptyAtomicTypeConjunction) throws PersistenceException{
        this.handleMAbstractTypeConjunction(mNonEmptyAtomicTypeConjunction);
    }
    public void handleMEmptyTypeConjunction(PersistentMEmptyTypeConjunction mEmptyTypeConjunction) throws PersistenceException{
        this.handleMAbstractTypeConjunction(mEmptyTypeConjunction);
    }
    public void handleMMixedConjunction(PersistentMMixedConjunction mMixedConjunction) throws PersistenceException{
        this.handleMAbstractTypeConjunction(mMixedConjunction);
    }
    
}
