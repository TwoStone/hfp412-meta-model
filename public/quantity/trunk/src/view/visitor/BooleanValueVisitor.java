
package view.visitor;

import view.*;

public interface BooleanValueVisitor {
    
    public void handleBooleanFalse(BooleanFalseView booleanFalse) throws ModelException;
    public void handleBooleanTrue(BooleanTrueView booleanTrue) throws ModelException;
    
}
