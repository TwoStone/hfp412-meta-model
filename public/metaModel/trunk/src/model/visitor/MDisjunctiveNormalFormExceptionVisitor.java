
package model.visitor;
import model.UserException;
import persistence.*;

public interface MDisjunctiveNormalFormExceptionVisitor<E extends UserException> {
    
    public void handleMNonEmptyDisjunctiveNormalForm(PersistentMNonEmptyDisjunctiveNormalForm mNonEmptyDisjunctiveNormalForm) throws PersistenceException, E;
    public void handleMEmptyTypeDisjunction(PersistentMEmptyTypeDisjunction mEmptyTypeDisjunction) throws PersistenceException, E;
    
}
