
package model.visitor;

import persistence.*;

public interface MAbsOperationVisitor {
    
    public void handleMOperation(PersistentMOperation mOperation) throws PersistenceException;
    
}
