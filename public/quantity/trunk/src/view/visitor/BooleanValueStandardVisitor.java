
package view.visitor;

import view.*;

public abstract class BooleanValueStandardVisitor implements BooleanValueVisitor {
    
    public void handleBooleanTrue(BooleanTrueView booleanTrue) throws ModelException{
        this.standardHandling(booleanTrue);
    }
    public void handleBooleanFalse(BooleanFalseView booleanFalse) throws ModelException{
        this.standardHandling(booleanFalse);
    }
    protected abstract void standardHandling(BooleanValueView booleanValue) throws ModelException;
}
