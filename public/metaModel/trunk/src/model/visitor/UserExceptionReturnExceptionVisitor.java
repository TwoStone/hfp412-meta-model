
package model.visitor;
import model.UserException;
import persistence.*;

public interface UserExceptionReturnExceptionVisitor<R, E extends UserException> extends ConsistencyExceptionReturnExceptionVisitor<R, E> {
    
    public R handleExponentMatchingException(model.ExponentMatchingException exponentMatchingException) throws PersistenceException, E;
    public R handleConsistencyException(model.ConsistencyException consistencyException) throws PersistenceException, E;
    public R handleWrongSubTypeAspectException(model.WrongSubTypeAspectException wrongSubTypeAspectException) throws PersistenceException, E;
    public R handleNotAvailableException(model.NotAvailableException notAvailableException) throws PersistenceException, E;
    public R handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException, E;
    public R handleCycleException(model.CycleException cycleException) throws PersistenceException, E;
    public R handlePatternNotMatchException(model.PatternNotMatchException patternNotMatchException) throws PersistenceException, E;
    public R handleEmptyTypeException(model.EmptyTypeException emptyTypeException) throws PersistenceException, E;
    public R handleDoubleDefinitionException(model.DoubleDefinitionException doubleDefinitionException) throws PersistenceException, E;
    public R handleNotFoundException(model.NotFoundException notFoundException) throws PersistenceException, E;
    public R handleNotFinalizedException(model.NotFinalizedException notFinalizedException) throws PersistenceException, E;
    public R handleNotComputableException(model.NotComputableException notComputableException) throws PersistenceException, E;
    
}
