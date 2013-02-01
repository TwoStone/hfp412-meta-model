
package model.visitor;

import persistence.*;

public abstract class UserExceptionStandardVisitor implements UserExceptionVisitor {
    
    public void handleConsistencyException(model.ConsistencyException consistencyException) throws PersistenceException{
        this.standardHandling(consistencyException);
    }
    public void handleWrongSubTypeAspectException(model.WrongSubTypeAspectException wrongSubTypeAspectException) throws PersistenceException{
        this.standardHandling(wrongSubTypeAspectException);
    }
    public void handleExponentMatchingException(model.ExponentMatchingException exponentMatchingException) throws PersistenceException{
        this.standardHandling(exponentMatchingException);
    }
    public void handleCycleException(model.CycleException cycleException) throws PersistenceException{
        this.standardHandling(cycleException);
    }
    public void handlePatternNotMatchException(model.PatternNotMatchException patternNotMatchException) throws PersistenceException{
        this.standardHandling(patternNotMatchException);
    }
    public void handleNotAvailableException(model.NotAvailableException notAvailableException) throws PersistenceException{
        this.standardHandling(notAvailableException);
    }
    public void handleAlreadyFinalizedException(model.AlreadyFinalizedException alreadyFinalizedException) throws PersistenceException{
        this.standardHandling(alreadyFinalizedException);
    }
    public void handleEmptyTypeException(model.EmptyTypeException emptyTypeException) throws PersistenceException{
        this.standardHandling(emptyTypeException);
    }
    public void handleDoubleDefinitionException(model.DoubleDefinitionException doubleDefinitionException) throws PersistenceException{
        this.standardHandling(doubleDefinitionException);
    }
    public void handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException{
        this.standardHandling(restrictionException);
    }
    public void handleNotFinalizedException(model.NotFinalizedException notFinalizedException) throws PersistenceException{
        this.standardHandling(notFinalizedException);
    }
    protected abstract void standardHandling(model.UserException userException) throws PersistenceException;
}
