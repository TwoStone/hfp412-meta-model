
package model.visitor;

import persistence.EnumerationManagerCommand;
import persistence.PersistenceException;
import persistence.PersistentCreateEnumCommand;
import persistence.PersistentCreateEnumValueCommand;
import persistence.PersistentDeleteEnumCommand;
import persistence.PersistentDeleteEnumValueCommand;

public abstract class EnumerationManagerCommandStandardVisitor implements EnumerationManagerCommandVisitor {
    
    public void handleCreateEnumValueCommand(PersistentCreateEnumValueCommand createEnumValueCommand) throws PersistenceException{
        this.standardHandling(createEnumValueCommand);
    }
    public void handleDeleteEnumValueCommand(PersistentDeleteEnumValueCommand deleteEnumValueCommand) throws PersistenceException{
        this.standardHandling(deleteEnumValueCommand);
    }
    public void handleCreateEnumCommand(PersistentCreateEnumCommand createEnumCommand) throws PersistenceException{
        this.standardHandling(createEnumCommand);
    }
    public void handleDeleteEnumCommand(PersistentDeleteEnumCommand deleteEnumCommand) throws PersistenceException{
        this.standardHandling(deleteEnumCommand);
    }
    protected abstract void standardHandling(EnumerationManagerCommand enumerationManagerCommand) throws PersistenceException;
}
