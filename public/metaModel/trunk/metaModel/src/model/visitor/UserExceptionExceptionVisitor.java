
package model.visitor;

import model.*;
import persistence.*;

public interface UserExceptionExceptionVisitor<E extends model.UserException> {
    
    public void handleCycleException(model.CycleException cycleException) throws PersistenceException, E;
    public void handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException, E;
    
}
