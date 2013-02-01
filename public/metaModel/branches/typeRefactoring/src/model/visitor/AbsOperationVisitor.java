
package model.visitor;

import persistence.*;

public interface AbsOperationVisitor {
    
    public void handleOperation(PersistentOperation operation) throws PersistenceException;
    public void handleAssociation(PersistentAssociation association) throws PersistenceException;
    
}
