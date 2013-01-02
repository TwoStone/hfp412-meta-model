
package view.visitor;
import view.UserException;
import view.*;

public interface MBooleanExceptionVisitor<E extends UserException> {
    
    public void handleMFalse(MFalseView mFalse) throws ModelException, E;
    public void handleMTrue(MTrueView mTrue) throws ModelException, E;
    
}
