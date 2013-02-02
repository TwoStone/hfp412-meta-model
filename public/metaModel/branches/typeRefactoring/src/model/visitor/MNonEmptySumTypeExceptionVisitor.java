
package model.visitor;
import model.UserException;
import persistence.*;

public interface MNonEmptySumTypeExceptionVisitor<E extends UserException> {
    
    public void handleMDisjunctiveNF(PersistentMDisjunctiveNF mDisjunctiveNF) throws PersistenceException, E;
    public void handleMSumType(PersistentMSumType mSumType) throws PersistenceException, E;
    
}
