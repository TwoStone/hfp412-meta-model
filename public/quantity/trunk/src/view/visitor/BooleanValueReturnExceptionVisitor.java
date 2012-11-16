
package view.visitor;
import view.UserException;
import view.*;

public interface BooleanValueReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleBooleanFalse(BooleanFalseView booleanFalse) throws ModelException, E;
    public R handleBooleanTrue(BooleanTrueView booleanTrue) throws ModelException, E;
    
}
