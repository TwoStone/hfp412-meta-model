
package view.visitor;

import view.*;

public abstract class UserExceptionStandardVisitor implements UserExceptionVisitor {
    
    public void handleCycleException(CycleException cycleException) throws ModelException{
        this.standardHandling(cycleException);
    }
    public void handleRestrictionException(RestrictionException restrictionException) throws ModelException{
        this.standardHandling(restrictionException);
    }
    public void handleDoubleDefinition(DoubleDefinition doubleDefinition) throws ModelException{
        this.standardHandling(doubleDefinition);
    }
    protected abstract void standardHandling(UserException userException) throws ModelException;
}
