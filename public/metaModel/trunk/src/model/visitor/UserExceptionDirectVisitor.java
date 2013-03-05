
package model.visitor;

import persistence.PersistenceException;

public abstract class UserExceptionDirectVisitor implements UserExceptionVisitor {
    
    public abstract void handleExponentMatchingException(model.ExponentMatchingException exponentMatchingException) throws PersistenceException;
    
    public abstract void handleWrongSubTypeAspectException(model.WrongSubTypeAspectException wrongSubTypeAspectException) throws PersistenceException;
    
    public abstract void handleConsistencyException(model.ConsistencyException consistencyException) throws PersistenceException;
    
    public void handleDeletedException(model.DeletedException deletedException) throws PersistenceException{
        this.handleConsistencyException(deletedException);
    }
    public abstract void handleCycleException(model.CycleException cycleException) throws PersistenceException;
    
    public abstract void handlePatternNotMatchException(model.PatternNotMatchException patternNotMatchException) throws PersistenceException;
    
    public abstract void handleNotAvailableException(model.NotAvailableException notAvailableException) throws PersistenceException;
    
    public abstract void handleEmptyTypeException(model.EmptyTypeException emptyTypeException) throws PersistenceException;
    
    public abstract void handleNotFoundException(model.NotFoundException notFoundException) throws PersistenceException;
    
    public abstract void handleDoubleDefinitionException(model.DoubleDefinitionException doubleDefinitionException) throws PersistenceException;
    
    public abstract void handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException;
    
    public abstract void handleNotComputableException(model.NotComputableException notComputableException) throws PersistenceException;
    
    
}
