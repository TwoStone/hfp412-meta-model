
package model.visitor;
import model.UserException;
import persistence.*;

public interface UserExceptionExceptionVisitor<E extends UserException> {
    
    public void handleCycleException(model.CycleException cycleException) throws PersistenceException, E;
    public void handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException, E;
    
}
