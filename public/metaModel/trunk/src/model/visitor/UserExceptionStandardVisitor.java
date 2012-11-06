
package model.visitor;

import model.*;
import persistence.*;

public abstract class UserExceptionStandardVisitor implements UserExceptionVisitor {
    
    public void handleWrongSubTypeAspectException(model.WrongSubTypeAspectException wrongSubTypeAspectException) throws PersistenceException{
        this.standardHandling(wrongSubTypeAspectException);
    }
    public void handleCycleException(model.CycleException cycleException) throws PersistenceException{
        this.standardHandling(cycleException);
    }
    public void handleDoubleDefinitionException(model.DoubleDefinitionException doubleDefinitionException) throws PersistenceException{
        this.standardHandling(doubleDefinitionException);
    }
    public void handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException{
        this.standardHandling(restrictionException);
    }
    protected abstract void standardHandling(model.UserException userException) throws PersistenceException;
}
