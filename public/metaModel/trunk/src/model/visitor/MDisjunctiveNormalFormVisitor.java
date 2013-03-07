
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentMEmptyTypeDisjunction;
import persistence.PersistentMNonEmptyDisjunctiveNormalForm;

public interface MDisjunctiveNormalFormVisitor {
    
    public void handleMNonEmptyDisjunctiveNormalForm(PersistentMNonEmptyDisjunctiveNormalForm mNonEmptyDisjunctiveNormalForm) throws PersistenceException;
    public void handleMEmptyTypeDisjunction(PersistentMEmptyTypeDisjunction mEmptyTypeDisjunction) throws PersistenceException;
    
}
