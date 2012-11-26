
package model.visitor;

import persistence.*;

public interface CommonDateReturnVisitor<R> {
    
    public R handleCreateHierarchyCommand(PersistentCreateHierarchyCommand createHierarchyCommand) throws PersistenceException;
    public R handleAddToHierarchyCommand(PersistentAddToHierarchyCommand addToHierarchyCommand) throws PersistenceException;
    public R handleAddSubTypeCommand(PersistentAddSubTypeCommand addSubTypeCommand) throws PersistenceException;
    public R handleCreateAspectCommand(PersistentCreateAspectCommand createAspectCommand) throws PersistenceException;
    public R handleCreateAtomicTypeCommand(PersistentCreateAtomicTypeCommand createAtomicTypeCommand) throws PersistenceException;
    public R handleCreateAssociationCommand(PersistentCreateAssociationCommand createAssociationCommand) throws PersistenceException;
    public R handleCreateSubTypeCommand(PersistentCreateSubTypeCommand createSubTypeCommand) throws PersistenceException;
    public R handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    
}
