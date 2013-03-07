
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentAssociation;
import persistence.PersistentOperation;

public interface AbsOperationReturnVisitor<R> {
    
    public R handleOperation(PersistentOperation operation) throws PersistenceException;
    public R handleAssociation(PersistentAssociation association) throws PersistenceException;
    
}
