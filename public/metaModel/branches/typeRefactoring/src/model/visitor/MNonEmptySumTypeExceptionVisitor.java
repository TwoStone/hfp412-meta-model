
package model.visitor;
import model.UserException;
import persistence.*;

public interface MNonEmptySumTypeExceptionVisitor<E extends UserException> {
    
    public void handleMDisjuncitveNF(PersistentMDisjuncitveNF mDisjuncitveNF) throws PersistenceException, E;
    public void handleMSumType(PersistentMSumType mSumType) throws PersistenceException, E;
    
}
