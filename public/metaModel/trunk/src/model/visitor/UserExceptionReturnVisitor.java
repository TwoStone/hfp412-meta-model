
package model.visitor;

import model.*;
import persistence.*;

public interface UserExceptionReturnVisitor<R> {
    
    public R handleCycleException(model.CycleException cycleException) throws PersistenceException;
    public R handleDoubleDefinitionException(model.DoubleDefinitionException doubleDefinitionException) throws PersistenceException;
    public R handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException;
    
}
