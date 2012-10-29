
package view.visitor;

import view.*;

public abstract class UserExceptionStandardVisitor implements UserExceptionVisitor {
    
    public void handleCycleException(CycleException cycleException) throws ModelException{
        this.standardHandling(cycleException);
    }
    public void handleDivisionByZeroException(DivisionByZeroException divisionByZeroException) throws ModelException{
        this.standardHandling(divisionByZeroException);
    }
    public void handleRestrictionException(RestrictionException restrictionException) throws ModelException{
        this.standardHandling(restrictionException);
    }
    protected abstract void standardHandling(UserException userException) throws ModelException;
}
