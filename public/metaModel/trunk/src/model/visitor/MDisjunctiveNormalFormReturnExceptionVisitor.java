
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentMEmptyTypeDisjunction;
import persistence.PersistentMNonEmptyDisjunctiveNormalForm;

public interface MDisjunctiveNormalFormReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleMNonEmptyDisjunctiveNormalForm(PersistentMNonEmptyDisjunctiveNormalForm mNonEmptyDisjunctiveNormalForm) throws PersistenceException, E;
    public R handleMEmptyTypeDisjunction(PersistentMEmptyTypeDisjunction mEmptyTypeDisjunction) throws PersistenceException, E;
    
}
