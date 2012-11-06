
package view.visitor;

import view.*;

public interface UserExceptionVisitor {
    
    public void handleWrongSubTypeAspectException(WrongSubTypeAspectException wrongSubTypeAspectException) throws ModelException;
    public void handleCycleException(CycleException cycleException) throws ModelException;
    public void handleDoubleDefinitionException(DoubleDefinitionException doubleDefinitionException) throws ModelException;
    public void handleRestrictionException(RestrictionException restrictionException) throws ModelException;
    
}
