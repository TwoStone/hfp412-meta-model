
package model.visitor;

import model.*;
import persistence.*;

public interface UserExceptionVisitor {
    
    public void handleWrongSubTypeAspectException(model.WrongSubTypeAspectException wrongSubTypeAspectException) throws PersistenceException;
    public void handleCycleException(model.CycleException cycleException) throws PersistenceException;
    public void handleDoubleDefinitionException(model.DoubleDefinitionException doubleDefinitionException) throws PersistenceException;
    public void handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException;
    
}
