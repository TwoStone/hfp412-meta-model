
package model.visitor;

import persistence.*;

public interface ObjectManagerCommandReturnVisitor<R> {
    
    public R handleAddTypeCommand(PersistentAddTypeCommand addTypeCommand) throws PersistenceException;
    public R handleCreateMObjectCommand(PersistentCreateMObjectCommand createMObjectCommand) throws PersistenceException;
    public R handleRemoveTypeCommand(PersistentRemoveTypeCommand removeTypeCommand) throws PersistenceException;
    public R handleReplaceTypeCommand(PersistentReplaceTypeCommand replaceTypeCommand) throws PersistenceException;
    
}
