
package model.visitor;
import model.UserException;
import persistence.*;

public interface AssociationManagerCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleCreateHierarchyCommand(PersistentCreateHierarchyCommand createHierarchyCommand) throws PersistenceException, E;
    public R handleAddToHierarchyCommand(PersistentAddToHierarchyCommand addToHierarchyCommand) throws PersistenceException, E;
    public R handleCreateAssociationCommand(PersistentCreateAssociationCommand createAssociationCommand) throws PersistenceException, E;
    
}
