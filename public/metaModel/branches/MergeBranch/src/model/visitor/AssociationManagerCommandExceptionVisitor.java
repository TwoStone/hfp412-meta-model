
package model.visitor;
import model.UserException;
import persistence.*;

public interface AssociationManagerCommandExceptionVisitor<E extends UserException> {
    
    public void handleCreateHierarchyCommand(PersistentCreateHierarchyCommand createHierarchyCommand) throws PersistenceException, E;
    public void handleAddToHierarchyCommand(PersistentAddToHierarchyCommand addToHierarchyCommand) throws PersistenceException, E;
    public void handleCreateAssociationCommand(PersistentCreateAssociationCommand createAssociationCommand) throws PersistenceException, E;
    
}
