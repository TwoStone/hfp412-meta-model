
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentMEmptySumType;
import persistence.PersistentMSumType;

public interface MAbstractSumTypeReturnVisitor<R> {
    
    public R handleMEmptySumType(PersistentMEmptySumType mEmptySumType) throws PersistenceException;
    public R handleMSumType(PersistentMSumType mSumType) throws PersistenceException;
    
}
