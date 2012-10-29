
package model.visitor;

import model.*;
import persistence.*;

public interface UserExceptionVisitor {
    
    public void handleCycleException(model.CycleException cycleException) throws PersistenceException;
    public void handleDivisionByZeroException(model.DivisionByZeroException divisionByZeroException) throws PersistenceException;
    public void handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException;
    
}
