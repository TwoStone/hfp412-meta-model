
package model.visitor;
import model.UserException;
import persistence.*;

public interface MSumTypeExceptionVisitor<E extends UserException> {
    
    public void handleMEmptySum(PersistentMEmptySum mEmptySum) throws PersistenceException, E;
    public void handleMSumType(PersistentMSumType mSumType) throws PersistenceException, E;
    
}
