
package model.visitor;
import model.UserException;
import persistence.*;

public interface CommonDateReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleCreateHierarchyCommand(PersistentCreateHierarchyCommand createHierarchyCommand) throws PersistenceException, E;
    public R handleAddToHierarchyCommand(PersistentAddToHierarchyCommand addToHierarchyCommand) throws PersistenceException, E;
    public R handleAddSubTypeCommand(PersistentAddSubTypeCommand addSubTypeCommand) throws PersistenceException, E;
    public R handleCreateAspectCommand(PersistentCreateAspectCommand createAspectCommand) throws PersistenceException, E;
    public R handleCreateAtomicTypeCommand(PersistentCreateAtomicTypeCommand createAtomicTypeCommand) throws PersistenceException, E;
    public R handleCreateAssociationCommand(PersistentCreateAssociationCommand createAssociationCommand) throws PersistenceException, E;
    public R handleCreateSubTypeCommand(PersistentCreateSubTypeCommand createSubTypeCommand) throws PersistenceException, E;
    public R handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException, E;
    
}
