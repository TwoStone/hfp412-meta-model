
package view.visitor;

import view.*;

public interface AbsOperationVisitor {
    
    public void handleOperation(OperationView operation) throws ModelException;
    public void handleAssociation(AssociationView association) throws ModelException;
    
}
