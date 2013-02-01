
package model.visitor;
import model.UserException;
import persistence.*;

public interface AssociationManagerCommandExceptionVisitor<E extends UserException> {
    
    public void handleRemoveAssoFrmHierCommand(PersistentRemoveAssoFrmHierCommand removeAssoFrmHierCommand) throws PersistenceException, E;
    public void handleCreateHierarchyCommand(PersistentCreateHierarchyCommand createHierarchyCommand) throws PersistenceException, E;
    public void handleRemoveAssociationCommand(PersistentRemoveAssociationCommand removeAssociationCommand) throws PersistenceException, E;
    public void handleAddAssociationCommand(PersistentAddAssociationCommand addAssociationCommand) throws PersistenceException, E;
    public void handleCreateAssociationCommand(PersistentCreateAssociationCommand createAssociationCommand) throws PersistenceException, E;
    
}
