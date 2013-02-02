
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentAssignNameCommand;
import persistence.PersistentAssignTypeCommand;
import persistence.PersistentCreateNameSchemeCommand;

public interface NameSchemeManagerCommandVisitor {
    
    public void handleAssignTypeCommand(PersistentAssignTypeCommand assignTypeCommand) throws PersistenceException;
    public void handleAssignNameCommand(PersistentAssignNameCommand assignNameCommand) throws PersistenceException;
    public void handleCreateNameSchemeCommand(PersistentCreateNameSchemeCommand createNameSchemeCommand) throws PersistenceException;
    
}
