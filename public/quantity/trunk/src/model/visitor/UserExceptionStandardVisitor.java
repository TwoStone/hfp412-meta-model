
package model.visitor;

import persistence.*;

public abstract class UserExceptionStandardVisitor implements UserExceptionVisitor {
    
    public void handleCycleException(model.CycleException cycleException) throws PersistenceException{
        this.standardHandling(cycleException);
    }
    public void handleAlreadyFinalizedException(model.AlreadyFinalizedException alreadyFinalizedException) throws PersistenceException{
        this.standardHandling(alreadyFinalizedException);
    }
    public void handleDoubleDefinitionException(model.DoubleDefinitionException doubleDefinitionException) throws PersistenceException{
        this.standardHandling(doubleDefinitionException);
    }
    public void handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException{
        this.standardHandling(restrictionException);
    }
    public void handleNotFinalizedException(model.NotFinalizedException notFinalizedException) throws PersistenceException{
        this.standardHandling(notFinalizedException);
    }
    protected abstract void standardHandling(model.UserException userException) throws PersistenceException;
}
