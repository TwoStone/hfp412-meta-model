
package view.visitor;
import view.UserException;
import view.*;

public interface UserExceptionReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleWrongSubTypeAspectException(WrongSubTypeAspectException wrongSubTypeAspectException) throws ModelException, E;
    public R handleConsistencyException(ConsistencyException consistencyException) throws ModelException, E;
    public R handleCycleException(CycleException cycleException) throws ModelException, E;
    public R handleDoubleDefinitionException(DoubleDefinitionException doubleDefinitionException) throws ModelException, E;
    public R handleRestrictionException(RestrictionException restrictionException) throws ModelException, E;
    
}
