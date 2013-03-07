
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentAddTypeCommand;
import persistence.PersistentCreateMObjectCommand;
import persistence.PersistentRemoveTypeCommand;
import persistence.PersistentReplaceTypeCommand;

public interface ObjectManagerCommandReturnVisitor<R> {
    
    public R handleCreateMObjectCommand(PersistentCreateMObjectCommand createMObjectCommand) throws PersistenceException;
    public R handleAddTypeCommand(PersistentAddTypeCommand addTypeCommand) throws PersistenceException;
    public R handleRemoveTypeCommand(PersistentRemoveTypeCommand removeTypeCommand) throws PersistenceException;
    public R handleReplaceTypeCommand(PersistentReplaceTypeCommand replaceTypeCommand) throws PersistenceException;
    
}
