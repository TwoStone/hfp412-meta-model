
package model.visitor;
import model.UserException;
import persistence.*;

public interface MAtomicTypeConjunctionExceptionVisitor<E extends UserException> {
    
    public void handleMNonEmptyAtomicTypeConjunction(PersistentMNonEmptyAtomicTypeConjunction mNonEmptyAtomicTypeConjunction) throws PersistenceException, E;
    public void handleMEmptyTypeConjunction(PersistentMEmptyTypeConjunction mEmptyTypeConjunction) throws PersistenceException, E;
    
}
