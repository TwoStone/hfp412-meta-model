
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentAddAssociationCommand;
import persistence.PersistentCreateAssociationCommand;
import persistence.PersistentCreateHierarchyCommand;
import persistence.PersistentRemoveAssoFrmHierCommand;
import persistence.PersistentRemoveAssociationCommand;

public interface AssociationManagerCommandVisitor {
    
    public void handleRemoveAssoFrmHierCommand(PersistentRemoveAssoFrmHierCommand removeAssoFrmHierCommand) throws PersistenceException;
    public void handleCreateHierarchyCommand(PersistentCreateHierarchyCommand createHierarchyCommand) throws PersistenceException;
    public void handleRemoveAssociationCommand(PersistentRemoveAssociationCommand removeAssociationCommand) throws PersistenceException;
    public void handleAddAssociationCommand(PersistentAddAssociationCommand addAssociationCommand) throws PersistenceException;
    public void handleCreateAssociationCommand(PersistentCreateAssociationCommand createAssociationCommand) throws PersistenceException;
    
}
