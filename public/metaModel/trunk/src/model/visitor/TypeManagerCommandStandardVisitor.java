
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentCreateAtomicRootTypeCommand;
import persistence.PersistentCreateAtomicSubTypeCommand;
import persistence.PersistentCreateProductTypeCommand;
import persistence.PersistentCreateSumTypeCommand;
import persistence.TypeManagerCommand;

public abstract class TypeManagerCommandStandardVisitor implements TypeManagerCommandVisitor {
    
    public void handleCreateAtomicSubTypeCommand(PersistentCreateAtomicSubTypeCommand createAtomicSubTypeCommand) throws PersistenceException{
        this.standardHandling(createAtomicSubTypeCommand);
    }
    public void handleCreateSumTypeCommand(PersistentCreateSumTypeCommand createSumTypeCommand) throws PersistenceException{
        this.standardHandling(createSumTypeCommand);
    }
    public void handleCreateProductTypeCommand(PersistentCreateProductTypeCommand createProductTypeCommand) throws PersistenceException{
        this.standardHandling(createProductTypeCommand);
    }
    public void handleCreateAtomicRootTypeCommand(PersistentCreateAtomicRootTypeCommand createAtomicRootTypeCommand) throws PersistenceException{
        this.standardHandling(createAtomicRootTypeCommand);
    }
    protected abstract void standardHandling(TypeManagerCommand typeManagerCommand) throws PersistenceException;
}
