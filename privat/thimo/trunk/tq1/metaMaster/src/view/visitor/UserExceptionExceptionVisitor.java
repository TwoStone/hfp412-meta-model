
package view.visitor;

import view.*;

public interface UserExceptionExceptionVisitor<E extends model.UserException> {
    
    public void handleCycleException(CycleException cycleException) throws ModelException, E;
    public void handleRestrictionException(RestrictionException restrictionException) throws ModelException, E;
    public void handleDoubleDefinition(DoubleDefinition doubleDefinition) throws ModelException, E;
    
}
