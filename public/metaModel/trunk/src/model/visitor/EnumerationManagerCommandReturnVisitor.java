
package model.visitor;

import persistence.*;

public interface EnumerationManagerCommandReturnVisitor<R> {
    
    public R handleCreateEnumCommand(PersistentCreateEnumCommand createEnumCommand) throws PersistenceException;
    public R handleDeleteEnumCommand(PersistentDeleteEnumCommand deleteEnumCommand) throws PersistenceException;
    
}
