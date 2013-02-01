
package model.visitor;
import model.UserException;
import persistence.*;

public interface MAbstractSumTypeExceptionVisitor<E extends UserException> extends MNonEmptySumTypeExceptionVisitor<E>{
    
    public void handleMEmptySumType(PersistentMEmptySumType mEmptySumType) throws PersistenceException, E;
    
}
