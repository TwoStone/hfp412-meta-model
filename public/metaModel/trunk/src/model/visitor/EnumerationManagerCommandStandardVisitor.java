
package model.visitor;

import persistence.*;

public abstract class EnumerationManagerCommandStandardVisitor implements EnumerationManagerCommandVisitor {
    
    public void handleCreateEnumCommand(PersistentCreateEnumCommand createEnumCommand) throws PersistenceException{
        this.standardHandling(createEnumCommand);
    }
    public void handleDeleteEnumCommand(PersistentDeleteEnumCommand deleteEnumCommand) throws PersistenceException{
        this.standardHandling(deleteEnumCommand);
    }
    protected abstract void standardHandling(EnumerationManagerCommand enumerationManagerCommand) throws PersistenceException;
}
