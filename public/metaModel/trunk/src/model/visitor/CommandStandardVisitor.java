
package model.visitor;

import persistence.*;

public abstract class CommandStandardVisitor implements CommandVisitor {
    
    public void handleAddAtomicTypeCommand(PersistentAddAtomicTypeCommand addAtomicTypeCommand) throws PersistenceException{
        this.standardHandling(addAtomicTypeCommand);
    }
    protected abstract void standardHandling(Command command) throws PersistenceException;
}
