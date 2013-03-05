
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentMAtomicType;
import persistence.PersistentMEmptyTypeConjunction;
import persistence.PersistentMEmptyTypeDisjunction;
import persistence.PersistentMMixedConjunction;
import persistence.PersistentMMixedTypeDisjunction;
import persistence.PersistentMNonEmptyAtomicTypeConjunction;
import persistence.PersistentMNonEmptyDisjunctiveNormalForm;
import persistence.PersistentMType;

public abstract class MTypeStandardVisitor implements MTypeVisitor {
    
    public void handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException{
        this.standardHandling(mAtomicType);
    }
    public void handleMMixedTypeDisjunction(PersistentMMixedTypeDisjunction mMixedTypeDisjunction) throws PersistenceException{
        this.standardHandling(mMixedTypeDisjunction);
    }
    public void handleMNonEmptyAtomicTypeConjunction(PersistentMNonEmptyAtomicTypeConjunction mNonEmptyAtomicTypeConjunction) throws PersistenceException{
        this.standardHandling(mNonEmptyAtomicTypeConjunction);
    }
    public void handleMEmptyTypeConjunction(PersistentMEmptyTypeConjunction mEmptyTypeConjunction) throws PersistenceException{
        this.standardHandling(mEmptyTypeConjunction);
    }
    public void handleMEmptyTypeDisjunction(PersistentMEmptyTypeDisjunction mEmptyTypeDisjunction) throws PersistenceException{
        this.standardHandling(mEmptyTypeDisjunction);
    }
    public void handleMMixedConjunction(PersistentMMixedConjunction mMixedConjunction) throws PersistenceException{
        this.standardHandling(mMixedConjunction);
    }
    public void handleMNonEmptyDisjunctiveNormalForm(PersistentMNonEmptyDisjunctiveNormalForm mNonEmptyDisjunctiveNormalForm) throws PersistenceException{
        this.standardHandling(mNonEmptyDisjunctiveNormalForm);
    }
    protected abstract void standardHandling(PersistentMType mType) throws PersistenceException;
}
