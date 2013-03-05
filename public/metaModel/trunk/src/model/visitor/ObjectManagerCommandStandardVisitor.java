
package model.visitor;

import persistence.ObjectManagerCommand;
import persistence.PersistenceException;
import persistence.PersistentAddTypeCommand;
import persistence.PersistentCreateMObjectCommand;
import persistence.PersistentRemoveTypeCommand;
import persistence.PersistentReplaceTypeCommand;

public abstract class ObjectManagerCommandStandardVisitor implements ObjectManagerCommandVisitor {
    
    public void handleAddTypeCommand(PersistentAddTypeCommand addTypeCommand) throws PersistenceException{
        this.standardHandling(addTypeCommand);
    }
    public void handleCreateMObjectCommand(PersistentCreateMObjectCommand createMObjectCommand) throws PersistenceException{
        this.standardHandling(createMObjectCommand);
    }
    public void handleRemoveTypeCommand(PersistentRemoveTypeCommand removeTypeCommand) throws PersistenceException{
        this.standardHandling(removeTypeCommand);
    }
    public void handleReplaceTypeCommand(PersistentReplaceTypeCommand replaceTypeCommand) throws PersistenceException{
        this.standardHandling(replaceTypeCommand);
    }
    protected abstract void standardHandling(ObjectManagerCommand objectManagerCommand) throws PersistenceException;
}
