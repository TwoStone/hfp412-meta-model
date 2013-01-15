
package view.visitor;

import view.*;

public abstract class MAbsOperationStandardVisitor implements MAbsOperationVisitor {
    
    public void handleMOperation(MOperationView mOperation) throws ModelException{
        this.standardHandling(mOperation);
    }
    protected abstract void standardHandling(MAbsOperationView mAbsOperation) throws ModelException;
}
