
package model.visitor;

import persistence.*;

public interface MAbsOperationReturnVisitor<R> {
    
    public R handleMOperation(PersistentMOperation mOperation) throws PersistenceException;
    
}
