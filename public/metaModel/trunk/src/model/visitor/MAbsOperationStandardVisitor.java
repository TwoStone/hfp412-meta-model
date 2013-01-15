
package model.visitor;

import persistence.*;

public abstract class MAbsOperationStandardVisitor implements MAbsOperationVisitor {
    
    public void handleMOperation(PersistentMOperation mOperation) throws PersistenceException{
        this.standardHandling(mOperation);
    }
    protected abstract void standardHandling(PersistentMAbsOperation mAbsOperation) throws PersistenceException;
}
