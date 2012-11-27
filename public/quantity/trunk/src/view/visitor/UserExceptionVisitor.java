
package view.visitor;

import view.*;

public interface UserExceptionVisitor {
    
    public void handleCycleException(CycleException cycleException) throws ModelException;
    public void handleAlreadyFinalizedException(AlreadyFinalizedException alreadyFinalizedException) throws ModelException;
    public void handleDoubleDefinitionException(DoubleDefinitionException doubleDefinitionException) throws ModelException;
    public void handleNotFinalizedException(NotFinalizedException notFinalizedException) throws ModelException;
    public void handleRestrictionException(RestrictionException restrictionException) throws ModelException;
    
}
