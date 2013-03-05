
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentMDisjunctiveNormalForm;
import persistence.PersistentMEmptyTypeDisjunction;
import persistence.PersistentMNonEmptyDisjunctiveNormalForm;

public abstract class MDisjunctiveNormalFormStandardVisitor implements MDisjunctiveNormalFormVisitor {
    
    public void handleMEmptyTypeDisjunction(PersistentMEmptyTypeDisjunction mEmptyTypeDisjunction) throws PersistenceException{
        this.standardHandling(mEmptyTypeDisjunction);
    }
    public void handleMNonEmptyDisjunctiveNormalForm(PersistentMNonEmptyDisjunctiveNormalForm mNonEmptyDisjunctiveNormalForm) throws PersistenceException{
        this.standardHandling(mNonEmptyDisjunctiveNormalForm);
    }
    protected abstract void standardHandling(PersistentMDisjunctiveNormalForm mDisjunctiveNormalForm) throws PersistenceException;
}
