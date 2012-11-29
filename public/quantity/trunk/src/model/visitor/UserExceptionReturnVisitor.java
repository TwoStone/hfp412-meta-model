
package model.visitor;

import persistence.*;

public interface UserExceptionReturnVisitor<R> {
    
    public R handleExponentMatchingException(model.ExponentMatchingException exponentMatchingException) throws PersistenceException;
    public R handleCycleException(model.CycleException cycleException) throws PersistenceException;
    public R handleAlreadyFinalizedException(model.AlreadyFinalizedException alreadyFinalizedException) throws PersistenceException;
    public R handleDoubleDefinitionException(model.DoubleDefinitionException doubleDefinitionException) throws PersistenceException;
    public R handleNotFinalizedException(model.NotFinalizedException notFinalizedException) throws PersistenceException;
    public R handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException;
    
}
