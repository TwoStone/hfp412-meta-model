
package view.visitor;
import view.UserException;
import view.*;

public interface MBooleanReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleMFalse(MFalseView mFalse) throws ModelException, E;
    public R handleMTrue(MTrueView mTrue) throws ModelException, E;
    
}
