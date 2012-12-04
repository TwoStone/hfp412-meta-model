
package model.visitor;

import persistence.*;

public interface CommonDateVisitor {
    
    public void handleCreateHierarchyCommand(PersistentCreateHierarchyCommand createHierarchyCommand) throws PersistenceException;
    public void handleAddToHierarchyCommand(PersistentAddToHierarchyCommand addToHierarchyCommand) throws PersistenceException;
    public void handleAddSubTypeCommand(PersistentAddSubTypeCommand addSubTypeCommand) throws PersistenceException;
    public void handleCreateAspectCommand(PersistentCreateAspectCommand createAspectCommand) throws PersistenceException;
    public void handleCreateAtomicTypeCommand(PersistentCreateAtomicTypeCommand createAtomicTypeCommand) throws PersistenceException;
    public void handleCreateAssociationCommand(PersistentCreateAssociationCommand createAssociationCommand) throws PersistenceException;
    public void handleCreateSubTypeCommand(PersistentCreateSubTypeCommand createSubTypeCommand) throws PersistenceException;
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    
}
