
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentMMixedTypeDisjunction;

public interface MAbstractTypeDisjunctionReturnExceptionVisitor<R, E extends UserException> extends MDisjunctiveNormalFormReturnExceptionVisitor<R, E> {
    
    public R handleMMixedTypeDisjunction(PersistentMMixedTypeDisjunction mMixedTypeDisjunction) throws PersistenceException, E;
    
}
