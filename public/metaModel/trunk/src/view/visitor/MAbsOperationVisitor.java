
package view.visitor;

import view.*;

public interface MAbsOperationVisitor {
    
    public void handleMOperation(MOperationView mOperation) throws ModelException;
    
}
