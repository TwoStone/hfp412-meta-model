
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentMEmptySumType;
import persistence.PersistentMSumType;

public interface MAbstractSumTypeExceptionVisitor<E extends UserException> {
    
    public void handleMEmptySumType(PersistentMEmptySumType mEmptySumType) throws PersistenceException, E;
    public void handleMSumType(PersistentMSumType mSumType) throws PersistenceException, E;
    
}
