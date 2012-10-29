
package view.visitor;
import view.UserException;
import view.*;

public interface UserExceptionReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleCycleException(CycleException cycleException) throws ModelException, E;
    public R handleDivisionByZeroException(DivisionByZeroException divisionByZeroException) throws ModelException, E;
    public R handleRestrictionException(RestrictionException restrictionException) throws ModelException, E;
    
}
