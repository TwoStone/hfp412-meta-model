
package model.visitor;

import persistence.*;

public interface MDisjunctiveNormalFormReturnVisitor<R> {
    
    public R handleMNonEmptyDisjunctiveNormalForm(PersistentMNonEmptyDisjunctiveNormalForm mNonEmptyDisjunctiveNormalForm) throws PersistenceException;
    public R handleMEmptyTypeDisjunction(PersistentMEmptyTypeDisjunction mEmptyTypeDisjunction) throws PersistenceException;
    
}
