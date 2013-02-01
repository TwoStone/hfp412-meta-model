
package model.visitor;

import persistence.*;

public interface MAbstractSumTypeReturnVisitor<R> extends MNonEmptySumTypeReturnVisitor<R> {
    
    public R handleMEmptySumType(PersistentMEmptySumType mEmptySumType) throws PersistenceException;
    
}
