
package model.visitor;
import model.UserException;
import persistence.*;

public interface MAbstractSumTypeExceptionVisitor<E extends UserException> {
    
    public void handleMEmptySumType(PersistentMEmptySumType mEmptySumType) throws PersistenceException, E;
    public void handleMSumType(PersistentMSumType mSumType) throws PersistenceException, E;
    
}
