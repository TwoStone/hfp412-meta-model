
package model.visitor;
import model.UserException;
import persistence.*;

public interface MAbstractTypeDisjunctionReturnExceptionVisitor<R, E extends UserException> extends MDisjunctiveNormalFormReturnExceptionVisitor<R, E> {
    
    public R handleMMixedTypeDisjunction(PersistentMMixedTypeDisjunction mMixedTypeDisjunction) throws PersistenceException, E;
    
}
