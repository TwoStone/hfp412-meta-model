
package view.visitor;

import view.*;

public interface MBooleanReturnVisitor<R> {
    
    public R handleMFalse(MFalseView mFalse) throws ModelException;
    public R handleMTrue(MTrueView mTrue) throws ModelException;
    public R handleMBoolean(MBooleanView mBoolean) throws ModelException;
    
}
