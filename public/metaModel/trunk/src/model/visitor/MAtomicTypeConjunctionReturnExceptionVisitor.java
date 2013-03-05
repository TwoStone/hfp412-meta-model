
package model.visitor;
import model.UserException;
import persistence.*;

public interface MAtomicTypeConjunctionReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleMNonEmptyAtomicTypeConjunction(PersistentMNonEmptyAtomicTypeConjunction mNonEmptyAtomicTypeConjunction) throws PersistenceException, E;
    public R handleMEmptyTypeConjunction(PersistentMEmptyTypeConjunction mEmptyTypeConjunction) throws PersistenceException, E;
    
}
