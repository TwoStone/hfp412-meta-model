
package view.visitor;

import view.*;

public interface MBooleanVisitor {
    
    public void handleMFalse(MFalseView mFalse) throws ModelException;
    public void handleMTrue(MTrueView mTrue) throws ModelException;
    public void handleMBoolean(MBooleanView mBoolean) throws ModelException;
    
}
