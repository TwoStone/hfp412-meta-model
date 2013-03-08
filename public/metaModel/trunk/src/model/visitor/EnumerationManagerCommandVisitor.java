
package model.visitor;

import persistence.*;

public interface EnumerationManagerCommandVisitor {
    
    public void handleCreateEnumCommand(PersistentCreateEnumCommand createEnumCommand) throws PersistenceException;
    public void handleDeleteEnumCommand(PersistentDeleteEnumCommand deleteEnumCommand) throws PersistenceException;
    
}
