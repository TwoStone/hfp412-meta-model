
package view.visitor;
import view.UserException;
import view.*;

public interface UserExceptionExceptionVisitor<E extends UserException> {
    
    public void handleCycleException(CycleException cycleException) throws ModelException, E;
    public void handleDivisionByZeroException(DivisionByZeroException divisionByZeroException) throws ModelException, E;
    public void handleRestrictionException(RestrictionException restrictionException) throws ModelException, E;
    
}
