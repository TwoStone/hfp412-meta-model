
package model.visitor;

import persistence.*;

public interface MNonEmptySumTypeReturnVisitor<R> {
    
    public R handleMDisjuncitveNF(PersistentMDisjuncitveNF mDisjuncitveNF) throws PersistenceException;
    public R handleMSumType(PersistentMSumType mSumType) throws PersistenceException;
    
}
