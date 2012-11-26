
package model.visitor;

import persistence.*;

public abstract class CommandStandardVisitor implements CommandVisitor {
    
    public void handleCreateAspectCommand(PersistentCreateAspectCommand createAspectCommand) throws PersistenceException{
        this.standardHandling(createAspectCommand);
    }
    public void handleCreateAtomicTypeCommand(PersistentCreateAtomicTypeCommand createAtomicTypeCommand) throws PersistenceException{
        this.standardHandling(createAtomicTypeCommand);
    }
    public void handleCreateHierarchyCommand(PersistentCreateHierarchyCommand createHierarchyCommand) throws PersistenceException{
        this.standardHandling(createHierarchyCommand);
    }
    public void handleCreateAssociationCommand(PersistentCreateAssociationCommand createAssociationCommand) throws PersistenceException{
        this.standardHandling(createAssociationCommand);
    }
    public void handleAddToHierarchyCommand(PersistentAddToHierarchyCommand addToHierarchyCommand) throws PersistenceException{
        this.standardHandling(addToHierarchyCommand);
    }
    public void handleAddSubTypeCommand(PersistentAddSubTypeCommand addSubTypeCommand) throws PersistenceException{
        this.standardHandling(addSubTypeCommand);
    }
    public void handleCreateSubTypeCommand(PersistentCreateSubTypeCommand createSubTypeCommand) throws PersistenceException{
        this.standardHandling(createSubTypeCommand);
    }
    protected abstract void standardHandling(Command command) throws PersistenceException;
}
