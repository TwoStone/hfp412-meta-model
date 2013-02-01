
package model.visitor;

import persistence.*;

public interface AbsOperationReturnVisitor<R> {
    
    public R handleOperation(PersistentOperation operation) throws PersistenceException;
    public R handleAssociation(PersistentAssociation association) throws PersistenceException;
    
}
