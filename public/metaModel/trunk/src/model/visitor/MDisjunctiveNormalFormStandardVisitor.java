
package model.visitor;

import persistence.*;

public abstract class MDisjunctiveNormalFormStandardVisitor implements MDisjunctiveNormalFormVisitor {
    
    public void handleMEmptyTypeDisjunction(PersistentMEmptyTypeDisjunction mEmptyTypeDisjunction) throws PersistenceException{
        this.standardHandling(mEmptyTypeDisjunction);
    }
    public void handleMNonEmptyDisjunctiveNormalForm(PersistentMNonEmptyDisjunctiveNormalForm mNonEmptyDisjunctiveNormalForm) throws PersistenceException{
        this.standardHandling(mNonEmptyDisjunctiveNormalForm);
    }
    protected abstract void standardHandling(PersistentMDisjunctiveNormalForm mDisjunctiveNormalForm) throws PersistenceException;
}
