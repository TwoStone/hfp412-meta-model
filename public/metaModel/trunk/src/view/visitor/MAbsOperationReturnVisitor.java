
package view.visitor;

import view.*;

public interface MAbsOperationReturnVisitor<R> {
    
    public R handleMOperation(MOperationView mOperation) throws ModelException;
    
}
