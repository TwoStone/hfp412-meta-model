
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentMMixedConjunction;

public interface MAbstractTypeConjunctionReturnExceptionVisitor<R, E extends UserException> extends MAtomicTypeConjunctionReturnExceptionVisitor<R, E> {
    
    public R handleMMixedConjunction(PersistentMMixedConjunction mMixedConjunction) throws PersistenceException, E;
    
}
