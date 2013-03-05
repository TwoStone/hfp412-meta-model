
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentMEmptyTypeDisjunction;
import persistence.PersistentMNonEmptyDisjunctiveNormalForm;

public interface MDisjunctiveNormalFormReturnVisitor<R> {
    
    public R handleMNonEmptyDisjunctiveNormalForm(PersistentMNonEmptyDisjunctiveNormalForm mNonEmptyDisjunctiveNormalForm) throws PersistenceException;
    public R handleMEmptyTypeDisjunction(PersistentMEmptyTypeDisjunction mEmptyTypeDisjunction) throws PersistenceException;
    
}
