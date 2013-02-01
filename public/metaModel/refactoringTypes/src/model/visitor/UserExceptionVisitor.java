
package model.visitor;

import persistence.*;

public interface UserExceptionVisitor {
    
    public void handleExponentMatchingException(model.ExponentMatchingException exponentMatchingException) throws PersistenceException;
    public void handleWrongSubTypeAspectException(model.WrongSubTypeAspectException wrongSubTypeAspectException) throws PersistenceException;
    public void handleConsistencyException(model.ConsistencyException consistencyException) throws PersistenceException;
    public void handleCycleException(model.CycleException cycleException) throws PersistenceException;
    public void handlePatternNotMatchException(model.PatternNotMatchException patternNotMatchException) throws PersistenceException;
    public void handleAlreadyFinalizedException(model.AlreadyFinalizedException alreadyFinalizedException) throws PersistenceException;
    public void handleNotAvailableException(model.NotAvailableException notAvailableException) throws PersistenceException;
    public void handleDoubleDefinitionException(model.DoubleDefinitionException doubleDefinitionException) throws PersistenceException;
    public void handleNotFinalizedException(model.NotFinalizedException notFinalizedException) throws PersistenceException;
    public void handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException;
    
}
