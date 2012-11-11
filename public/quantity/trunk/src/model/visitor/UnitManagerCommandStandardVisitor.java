
package model.visitor;

import persistence.*;

public abstract class UnitManagerCommandStandardVisitor implements UnitManagerCommandVisitor {
    
    public void handleCreateUnitCommand(PersistentCreateUnitCommand createUnitCommand) throws PersistenceException{
        this.standardHandling(createUnitCommand);
    }
    protected abstract void standardHandling(UnitManagerCommand unitManagerCommand) throws PersistenceException;
}
