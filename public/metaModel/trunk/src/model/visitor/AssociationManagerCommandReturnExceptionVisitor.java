
package model.visitor;
import model.UserException;
import persistence.*;

public interface AssociationManagerCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleRemoveHierarchyCommand(PersistentRemoveHierarchyCommand removeHierarchyCommand) throws PersistenceException, E;
    public R handleRemoveAssoFrmHierCommand(PersistentRemoveAssoFrmHierCommand removeAssoFrmHierCommand) throws PersistenceException, E;
    public R handleCreateHierarchyCommand(PersistentCreateHierarchyCommand createHierarchyCommand) throws PersistenceException, E;
    public R handleRemoveAssociationCommand(PersistentRemoveAssociationCommand removeAssociationCommand) throws PersistenceException, E;
    public R handleAddAssociationCommand(PersistentAddAssociationCommand addAssociationCommand) throws PersistenceException, E;
    public R handleCreateAssociationCommand(PersistentCreateAssociationCommand createAssociationCommand) throws PersistenceException, E;
    
}
