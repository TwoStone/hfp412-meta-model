
package view.visitor;

import view.*;

public abstract class UserExceptionStandardVisitor implements UserExceptionVisitor {
    
    public void handleConsistencyException(ConsistencyException consistencyException) throws ModelException{
        this.standardHandling(consistencyException);
    }
    public void handleWrongSubTypeAspectException(WrongSubTypeAspectException wrongSubTypeAspectException) throws ModelException{
        this.standardHandling(wrongSubTypeAspectException);
    }
    public void handleCycleException(CycleException cycleException) throws ModelException{
        this.standardHandling(cycleException);
    }
    public void handleDoubleDefinitionException(DoubleDefinitionException doubleDefinitionException) throws ModelException{
        this.standardHandling(doubleDefinitionException);
    }
    public void handleRestrictionException(RestrictionException restrictionException) throws ModelException{
        this.standardHandling(restrictionException);
    }
    protected abstract void standardHandling(UserException userException) throws ModelException;
}
