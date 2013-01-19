
package view.visitor;

import view.*;

public interface AbsOperationVisitor {
    
    public void handleOperation(OperationView operation) throws ModelException;
    
}
