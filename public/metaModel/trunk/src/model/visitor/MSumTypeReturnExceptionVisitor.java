
package model.visitor;
import model.UserException;
import persistence.*;

public interface MSumTypeReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleMEmptySum(PersistentMEmptySum mEmptySum) throws PersistenceException, E;
    public R handleMSumType(PersistentMSumType mSumType) throws PersistenceException, E;
    
}
