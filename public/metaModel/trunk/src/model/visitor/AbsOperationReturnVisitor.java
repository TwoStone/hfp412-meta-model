
package model.visitor;

import persistence.*;

public interface AbsOperationReturnVisitor<R> {
    
    public R handleOperation(PersistentOperation operation) throws PersistenceException;
    
}
