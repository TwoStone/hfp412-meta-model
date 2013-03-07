
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentCreateEnumCommand;
import persistence.PersistentCreateEnumValueCommand;
import persistence.PersistentDeleteEnumCommand;
import persistence.PersistentDeleteEnumValueCommand;

public interface EnumerationManagerCommandReturnVisitor<R> {
    
    public R handleCreateEnumCommand(PersistentCreateEnumCommand createEnumCommand) throws PersistenceException;
    public R handleDeleteEnumCommand(PersistentDeleteEnumCommand deleteEnumCommand) throws PersistenceException;
    public R handleCreateEnumValueCommand(PersistentCreateEnumValueCommand createEnumValueCommand) throws PersistenceException;
    public R handleDeleteEnumValueCommand(PersistentDeleteEnumValueCommand deleteEnumValueCommand) throws PersistenceException;
    
}
