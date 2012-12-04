
package model.visitor;
import model.UserException;
import persistence.*;

public interface CommonDateExceptionVisitor<E extends UserException> {
    
    public void handleCreateHierarchyCommand(PersistentCreateHierarchyCommand createHierarchyCommand) throws PersistenceException, E;
    public void handleAddToHierarchyCommand(PersistentAddToHierarchyCommand addToHierarchyCommand) throws PersistenceException, E;
    public void handleAddSubTypeCommand(PersistentAddSubTypeCommand addSubTypeCommand) throws PersistenceException, E;
    public void handleCreateAspectCommand(PersistentCreateAspectCommand createAspectCommand) throws PersistenceException, E;
    public void handleCreateAtomicTypeCommand(PersistentCreateAtomicTypeCommand createAtomicTypeCommand) throws PersistenceException, E;
    public void handleCreateAssociationCommand(PersistentCreateAssociationCommand createAssociationCommand) throws PersistenceException, E;
    public void handleCreateSubTypeCommand(PersistentCreateSubTypeCommand createSubTypeCommand) throws PersistenceException, E;
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException, E;
    
}
