
package model.visitor;

import persistence.*;

public interface MSumTypeReturnVisitor<R> {
    
    public R handleMEmptySum(PersistentMEmptySum mEmptySum) throws PersistenceException;
    public R handleMSumType(PersistentMSumType mSumType) throws PersistenceException;
    
}
