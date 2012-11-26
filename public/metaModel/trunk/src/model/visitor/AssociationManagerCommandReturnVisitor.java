
package model.visitor;

import persistence.*;

public interface AssociationManagerCommandReturnVisitor<R> {
    
    public R handleCreateHierarchyCommand(PersistentCreateHierarchyCommand createHierarchyCommand) throws PersistenceException;
    public R handleAddToHierarchyCommand(PersistentAddToHierarchyCommand addToHierarchyCommand) throws PersistenceException;
    public R handleCreateAssociationCommand(PersistentCreateAssociationCommand createAssociationCommand) throws PersistenceException;
    
}
