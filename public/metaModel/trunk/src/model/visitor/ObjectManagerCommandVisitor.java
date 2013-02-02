
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentAddTypeCommand;
import persistence.PersistentCreateMObjectCommand;
import persistence.PersistentRemoveTypeCommand;
import persistence.PersistentReplaceTypeCommand;

public interface ObjectManagerCommandVisitor {
    
    public void handleAddTypeCommand(PersistentAddTypeCommand addTypeCommand) throws PersistenceException;
    public void handleCreateMObjectCommand(PersistentCreateMObjectCommand createMObjectCommand) throws PersistenceException;
    public void handleRemoveTypeCommand(PersistentRemoveTypeCommand removeTypeCommand) throws PersistenceException;
    public void handleReplaceTypeCommand(PersistentReplaceTypeCommand replaceTypeCommand) throws PersistenceException;
    
}
