
package model.visitor;
import model.UserException;
import persistence.*;

public interface UserExceptionExceptionVisitor<E extends UserException> extends ConsistencyExceptionExceptionVisitor<E>{
    
    public void handleExponentMatchingException(model.ExponentMatchingException exponentMatchingException) throws PersistenceException, E;
    public void handleWrongSubTypeAspectException(model.WrongSubTypeAspectException wrongSubTypeAspectException) throws PersistenceException, E;
    public void handleConsistencyException(model.ConsistencyException consistencyException) throws PersistenceException, E;
    public void handleCycleException(model.CycleException cycleException) throws PersistenceException, E;
    public void handlePatternNotMatchException(model.PatternNotMatchException patternNotMatchException) throws PersistenceException, E;
    public void handleNotAvailableException(model.NotAvailableException notAvailableException) throws PersistenceException, E;
    public void handleEmptyTypeException(model.EmptyTypeException emptyTypeException) throws PersistenceException, E;
    public void handleNotFoundException(model.NotFoundException notFoundException) throws PersistenceException, E;
    public void handleDoubleDefinitionException(model.DoubleDefinitionException doubleDefinitionException) throws PersistenceException, E;
    public void handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException, E;
    public void handleNotComputableException(model.NotComputableException notComputableException) throws PersistenceException, E;
    
}
