
package model.visitor;
import model.UserException;
import model.*;
import persistence.*;

public interface UserExceptionReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleCycleException(model.CycleException cycleException) throws PersistenceException, E;
    public R handleDivisionByZeroException(model.DivisionByZeroException divisionByZeroException) throws PersistenceException, E;
    public R handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException, E;
    
}