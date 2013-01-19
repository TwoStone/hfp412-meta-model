
package view.visitor;
import view.UserException;
import view.*;

public interface UserExceptionExceptionVisitor<E extends UserException> {
    
    public void handleExponentMatchingException(ExponentMatchingException exponentMatchingException) throws ModelException, E;
    public void handleWrongSubTypeAspectException(WrongSubTypeAspectException wrongSubTypeAspectException) throws ModelException, E;
    public void handleConsistencyException(ConsistencyException consistencyException) throws ModelException, E;
    public void handleCycleException(CycleException cycleException) throws ModelException, E;
    public void handleAlreadyFinalizedException(AlreadyFinalizedException alreadyFinalizedException) throws ModelException, E;
    public void handleNotAvailableException(NotAvailableException notAvailableException) throws ModelException, E;
    public void handleDoubleDefinitionException(DoubleDefinitionException doubleDefinitionException) throws ModelException, E;
    public void handleNotFinalizedException(NotFinalizedException notFinalizedException) throws ModelException, E;
    public void handleRestrictionException(RestrictionException restrictionException) throws ModelException, E;
    
}
