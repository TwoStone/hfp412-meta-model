
package model.visitor;

import persistence.PersistenceException;

public interface UserExceptionReturnVisitor<R> extends ConsistencyExceptionReturnVisitor<R> {
    
    public R handleConsistencyException(model.ConsistencyException consistencyException) throws PersistenceException;
    public R handleWrongSubTypeAspectException(model.WrongSubTypeAspectException wrongSubTypeAspectException) throws PersistenceException;
    public R handleExponentMatchingException(model.ExponentMatchingException exponentMatchingException) throws PersistenceException;
    public R handleNotAvailableException(model.NotAvailableException notAvailableException) throws PersistenceException;
    public R handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException;
    public R handleCycleException(model.CycleException cycleException) throws PersistenceException;
    public R handlePatternNotMatchException(model.PatternNotMatchException patternNotMatchException) throws PersistenceException;
    public R handleEmptyTypeException(model.EmptyTypeException emptyTypeException) throws PersistenceException;
    public R handleDoubleDefinitionException(model.DoubleDefinitionException doubleDefinitionException) throws PersistenceException;
    public R handleNotFoundException(model.NotFoundException notFoundException) throws PersistenceException;
    public R handleNotComputableException(model.NotComputableException notComputableException) throws PersistenceException;
    
}
