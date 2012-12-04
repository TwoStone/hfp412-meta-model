
package view.visitor;

import view.*;

public abstract class MBooleanStandardVisitor implements MBooleanVisitor {
    
    public void handleMFalse(MFalseView mFalse) throws ModelException{
        this.standardHandling(mFalse);
    }
    public void handleMBoolean(MBooleanView mBoolean) throws ModelException{
        this.standardHandling(mBoolean);
    }
    public void handleMTrue(MTrueView mTrue) throws ModelException{
        this.standardHandling(mTrue);
    }
    protected abstract void standardHandling(MBooleanView mBoolean) throws ModelException;
}
