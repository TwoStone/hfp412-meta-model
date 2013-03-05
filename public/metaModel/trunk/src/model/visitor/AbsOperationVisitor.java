
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentAssociation;
import persistence.PersistentOperation;

public interface AbsOperationVisitor {
    
    public void handleOperation(PersistentOperation operation) throws PersistenceException;
    public void handleAssociation(PersistentAssociation association) throws PersistenceException;
    
}
