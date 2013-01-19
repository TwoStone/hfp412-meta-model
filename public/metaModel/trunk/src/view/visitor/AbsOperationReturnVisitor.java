
package view.visitor;

import view.*;

public interface AbsOperationReturnVisitor<R> {
    
    public R handleOperation(OperationView operation) throws ModelException;
    
}
