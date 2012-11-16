
package view.visitor;
import view.UserException;
import view.*;

public interface BooleanValueExceptionVisitor<E extends UserException> {
    
    public void handleBooleanFalse(BooleanFalseView booleanFalse) throws ModelException, E;
    public void handleBooleanTrue(BooleanTrueView booleanTrue) throws ModelException, E;
    
}
