
package model.visitor;
import model.UserException;
import persistence.*;

public interface MAbstractSumTypeReturnExceptionVisitor<R, E extends UserException> extends MNonEmptySumTypeReturnExceptionVisitor<R, E> {
    
    public R handleMEmptySumType(PersistentMEmptySumType mEmptySumType) throws PersistenceException, E;
    
}
