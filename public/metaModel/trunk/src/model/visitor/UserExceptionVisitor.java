
package model.visitor;

import persistence.PersistenceException;

public interface UserExceptionVisitor extends ConsistencyExceptionVisitor{
    
    public void handleConsistencyException(model.ConsistencyException consistencyException) throws PersistenceException;
    public void handleWrongSubTypeAspectException(model.WrongSubTypeAspectException wrongSubTypeAspectException) throws PersistenceException;
    public void handleExponentMatchingException(model.ExponentMatchingException exponentMatchingException) throws PersistenceException;
    public void handleNotAvailableException(model.NotAvailableException notAvailableException) throws PersistenceException;
    public void handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException;
    public void handleCycleException(model.CycleException cycleException) throws PersistenceException;
    public void handlePatternNotMatchException(model.PatternNotMatchException patternNotMatchException) throws PersistenceException;
    public void handleEmptyTypeException(model.EmptyTypeException emptyTypeException) throws PersistenceException;
    public void handleDoubleDefinitionException(model.DoubleDefinitionException doubleDefinitionException) throws PersistenceException;
    public void handleNotFoundException(model.NotFoundException notFoundException) throws PersistenceException;
    public void handleNotComputableException(model.NotComputableException notComputableException) throws PersistenceException;
    
}
