
package model.visitor;

import persistence.*;

public interface MNonEmptySumTypeReturnVisitor<R> {
    
    public R handleMDisjunctiveNF(PersistentMDisjunctiveNF mDisjunctiveNF) throws PersistenceException;
    public R handleMSumType(PersistentMSumType mSumType) throws PersistenceException;
    
}
