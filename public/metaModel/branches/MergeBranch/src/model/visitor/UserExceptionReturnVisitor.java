
package model.visitor;

import persistence.*;

public interface UserExceptionReturnVisitor<R> {
    
    public R handleWrongSubTypeAspectException(model.WrongSubTypeAspectException wrongSubTypeAspectException) throws PersistenceException;
    public R handleConsistencyException(model.ConsistencyException consistencyException) throws PersistenceException;
    public R handleCycleException(model.CycleException cycleException) throws PersistenceException;
    public R handleDoubleDefinitionException(model.DoubleDefinitionException doubleDefinitionException) throws PersistenceException;
    public R handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException;
    
}