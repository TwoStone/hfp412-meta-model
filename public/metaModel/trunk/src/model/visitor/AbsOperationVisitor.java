
package model.visitor;

import persistence.*;

public interface AbsOperationVisitor {
    
    public void handleOperation(PersistentOperation operation) throws PersistenceException;
    
}
