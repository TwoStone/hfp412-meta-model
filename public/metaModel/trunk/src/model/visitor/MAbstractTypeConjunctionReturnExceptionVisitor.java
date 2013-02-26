
package model.visitor;
import model.UserException;
import persistence.*;

public interface MAbstractTypeConjunctionReturnExceptionVisitor<R, E extends UserException> extends MAtomicTypeConjunctionReturnExceptionVisitor<R, E> {
    
    public R handleMMixedConjunction(PersistentMMixedConjunction mMixedConjunction) throws PersistenceException, E;
    
}
