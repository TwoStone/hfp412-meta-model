
package model.visitor;

import persistence.*;

public interface MAbstractSumTypeReturnVisitor<R> {
    
    public R handleMEmptySumType(PersistentMEmptySumType mEmptySumType) throws PersistenceException;
    public R handleMSumType(PersistentMSumType mSumType) throws PersistenceException;
    
}
