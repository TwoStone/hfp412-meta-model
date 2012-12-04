
package model.visitor;
import model.UserException;
import persistence.*;

public interface UserExceptionExceptionVisitor<E extends UserException> {
    
    public void handleWrongSubTypeAspectException(model.WrongSubTypeAspectException wrongSubTypeAspectException) throws PersistenceException, E;
    public void handleConsistencyException(model.ConsistencyException consistencyException) throws PersistenceException, E;
    public void handleCycleException(model.CycleException cycleException) throws PersistenceException, E;
    public void handleDoubleDefinitionException(model.DoubleDefinitionException doubleDefinitionException) throws PersistenceException, E;
    public void handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException, E;
    
}
