
package model.visitor;
import model.UserException;
import persistence.*;

public interface UserExceptionReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleExponentMatchingException(model.ExponentMatchingException exponentMatchingException) throws PersistenceException, E;
    public R handleCycleException(model.CycleException cycleException) throws PersistenceException, E;
    public R handleAlreadyFinalizedException(model.AlreadyFinalizedException alreadyFinalizedException) throws PersistenceException, E;
    public R handleDoubleDefinitionException(model.DoubleDefinitionException doubleDefinitionException) throws PersistenceException, E;
    public R handleNotFinalizedException(model.NotFinalizedException notFinalizedException) throws PersistenceException, E;
    public R handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException, E;
    
}
