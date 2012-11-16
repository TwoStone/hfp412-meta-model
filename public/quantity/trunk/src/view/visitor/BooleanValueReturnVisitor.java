
package view.visitor;

import view.*;

public interface BooleanValueReturnVisitor<R> {
    
    public R handleBooleanFalse(BooleanFalseView booleanFalse) throws ModelException;
    public R handleBooleanTrue(BooleanTrueView booleanTrue) throws ModelException;
    
}
