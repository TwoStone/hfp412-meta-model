
package model.visitor;
import model.UserException;
import persistence.*;

public interface MNonEmptySumTypeReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleMDisjunctiveNF(PersistentMDisjunctiveNF mDisjunctiveNF) throws PersistenceException, E;
    public R handleMSumType(PersistentMSumType mSumType) throws PersistenceException, E;
    
}
