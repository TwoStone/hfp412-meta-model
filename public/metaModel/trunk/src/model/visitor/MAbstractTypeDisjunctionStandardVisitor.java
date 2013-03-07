
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentMAbstractTypeDisjunction;
import persistence.PersistentMEmptyTypeDisjunction;
import persistence.PersistentMMixedTypeDisjunction;
import persistence.PersistentMNonEmptyDisjunctiveNormalForm;

public abstract class MAbstractTypeDisjunctionStandardVisitor implements MAbstractTypeDisjunctionVisitor {
    
    public void handleMMixedTypeDisjunction(PersistentMMixedTypeDisjunction mMixedTypeDisjunction) throws PersistenceException{
        this.standardHandling(mMixedTypeDisjunction);
    }
    public void handleMEmptyTypeDisjunction(PersistentMEmptyTypeDisjunction mEmptyTypeDisjunction) throws PersistenceException{
        this.standardHandling(mEmptyTypeDisjunction);
    }
    public void handleMNonEmptyDisjunctiveNormalForm(PersistentMNonEmptyDisjunctiveNormalForm mNonEmptyDisjunctiveNormalForm) throws PersistenceException{
        this.standardHandling(mNonEmptyDisjunctiveNormalForm);
    }
    protected abstract void standardHandling(PersistentMAbstractTypeDisjunction mAbstractTypeDisjunction) throws PersistenceException;
}
