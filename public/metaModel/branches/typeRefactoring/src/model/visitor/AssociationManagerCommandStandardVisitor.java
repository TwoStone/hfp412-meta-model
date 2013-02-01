
package model.visitor;

import persistence.*;

public abstract class AssociationManagerCommandStandardVisitor implements AssociationManagerCommandVisitor {
    
    public void handleRemoveAssoFrmHierCommand(PersistentRemoveAssoFrmHierCommand removeAssoFrmHierCommand) throws PersistenceException{
        this.standardHandling(removeAssoFrmHierCommand);
    }
    public void handleCreateAssociationCommand(PersistentCreateAssociationCommand createAssociationCommand) throws PersistenceException{
        this.standardHandling(createAssociationCommand);
    }
    public void handleCreateHierarchyCommand(PersistentCreateHierarchyCommand createHierarchyCommand) throws PersistenceException{
        this.standardHandling(createHierarchyCommand);
    }
    public void handleAddAssociationCommand(PersistentAddAssociationCommand addAssociationCommand) throws PersistenceException{
        this.standardHandling(addAssociationCommand);
    }
    public void handleRemoveAssociationCommand(PersistentRemoveAssociationCommand removeAssociationCommand) throws PersistenceException{
        this.standardHandling(removeAssociationCommand);
    }
    protected abstract void standardHandling(AssociationManagerCommand associationManagerCommand) throws PersistenceException;
}
