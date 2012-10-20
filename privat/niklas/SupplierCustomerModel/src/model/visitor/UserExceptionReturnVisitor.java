
package model.visitor;

import model.*;
import persistence.*;

public interface UserExceptionReturnVisitor<R> {
    
    public R handleCycleException(model.CycleException cycleException) throws PersistenceException;
    public R handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException;
    public R handleDoubleDefinition(model.DoubleDefinition doubleDefinition) throws PersistenceException;
    
}
