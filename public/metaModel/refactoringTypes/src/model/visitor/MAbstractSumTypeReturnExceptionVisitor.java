
package model.visitor;
import model.UserException;
import persistence.*;

public interface MAbstractSumTypeReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleMEmptySumType(PersistentMEmptySumType mEmptySumType) throws PersistenceException, E;
    public R handleMSumType(PersistentMSumType mSumType) throws PersistenceException, E;
    
}
