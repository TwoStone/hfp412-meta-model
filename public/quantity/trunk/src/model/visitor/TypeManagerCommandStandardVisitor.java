
package model.visitor;

import persistence.*;

public abstract class TypeManagerCommandStandardVisitor implements TypeManagerCommandVisitor {
    
    public void handleAddDefaultUnitCommand(PersistentAddDefaultUnitCommand addDefaultUnitCommand) throws PersistenceException{
        this.standardHandling(addDefaultUnitCommand);
    }
    public void handleCreateUnitTypeCommand(PersistentCreateUnitTypeCommand createUnitTypeCommand) throws PersistenceException{
        this.standardHandling(createUnitTypeCommand);
    }
    protected abstract void standardHandling(TypeManagerCommand typeManagerCommand) throws PersistenceException;
}
