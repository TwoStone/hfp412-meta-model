
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentMDisjunctiveNormalForm;
import persistence.PersistentMEmptyTypeDisjunction;
import persistence.PersistentMMixedTypeDisjunction;
import persistence.PersistentMNonEmptyDisjunctiveNormalForm;

public abstract class MAbstractTypeDisjunctionDirectVisitor implements MAbstractTypeDisjunctionVisitor {
    
    public abstract void handleMMixedTypeDisjunction(PersistentMMixedTypeDisjunction mMixedTypeDisjunction) throws PersistenceException;
    
    public abstract void handleMDisjunctiveNormalForm(PersistentMDisjunctiveNormalForm mDisjunctiveNormalForm) throws PersistenceException;
    
    public void handleMEmptyTypeDisjunction(PersistentMEmptyTypeDisjunction mEmptyTypeDisjunction) throws PersistenceException{
        this.handleMDisjunctiveNormalForm(mEmptyTypeDisjunction);
    }
    public void handleMNonEmptyDisjunctiveNormalForm(PersistentMNonEmptyDisjunctiveNormalForm mNonEmptyDisjunctiveNormalForm) throws PersistenceException{
        this.handleMDisjunctiveNormalForm(mNonEmptyDisjunctiveNormalForm);
    }
    
}
