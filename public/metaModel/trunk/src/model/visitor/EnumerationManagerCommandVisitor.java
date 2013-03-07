
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentCreateEnumCommand;
import persistence.PersistentCreateEnumValueCommand;
import persistence.PersistentDeleteEnumCommand;
import persistence.PersistentDeleteEnumValueCommand;

public interface EnumerationManagerCommandVisitor {
    
    public void handleCreateEnumCommand(PersistentCreateEnumCommand createEnumCommand) throws PersistenceException;
    public void handleDeleteEnumCommand(PersistentDeleteEnumCommand deleteEnumCommand) throws PersistenceException;
    public void handleCreateEnumValueCommand(PersistentCreateEnumValueCommand createEnumValueCommand) throws PersistenceException;
    public void handleDeleteEnumValueCommand(PersistentDeleteEnumValueCommand deleteEnumValueCommand) throws PersistenceException;
    
}
