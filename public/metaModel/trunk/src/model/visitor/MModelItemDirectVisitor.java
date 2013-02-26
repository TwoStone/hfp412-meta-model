
package model.visitor;

import persistence.*;

public abstract class MModelItemDirectVisitor implements MModelItemVisitor {
    
    public abstract void handleMType(PersistentMType mType) throws PersistenceException;
    
    public void handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException{
        this.handleMType(mAtomicType);
    }
    public void handleMMixedTypeDisjunction(PersistentMMixedTypeDisjunction mMixedTypeDisjunction) throws PersistenceException{
        this.handleMType(mMixedTypeDisjunction);
    }
    public void handleMNonEmptyAtomicTypeConjunction(PersistentMNonEmptyAtomicTypeConjunction mNonEmptyAtomicTypeConjunction) throws PersistenceException{
        this.handleMType(mNonEmptyAtomicTypeConjunction);
    }
    public void handleMEmptyTypeConjunction(PersistentMEmptyTypeConjunction mEmptyTypeConjunction) throws PersistenceException{
        this.handleMType(mEmptyTypeConjunction);
    }
    public void handleMEmptyTypeDisjunction(PersistentMEmptyTypeDisjunction mEmptyTypeDisjunction) throws PersistenceException{
        this.handleMType(mEmptyTypeDisjunction);
    }
    public void handleMMixedConjunction(PersistentMMixedConjunction mMixedConjunction) throws PersistenceException{
        this.handleMType(mMixedConjunction);
    }
    public void handleMNonEmptyDisjunctiveNormalForm(PersistentMNonEmptyDisjunctiveNormalForm mNonEmptyDisjunctiveNormalForm) throws PersistenceException{
        this.handleMType(mNonEmptyDisjunctiveNormalForm);
    }
    public abstract void handleCONCMModelItem(PersistentCONCMModelItem cONCMModelItem) throws PersistenceException;
    
    
}
