
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentAssignNameCommand;
import persistence.PersistentAssignTypeCommand;
import persistence.PersistentCreateNameSchemeCommand;

public interface NameSchemeManagerCommandReturnVisitor<R> {
    
    public R handleAssignTypeCommand(PersistentAssignTypeCommand assignTypeCommand) throws PersistenceException;
    public R handleAssignNameCommand(PersistentAssignNameCommand assignNameCommand) throws PersistenceException;
    public R handleCreateNameSchemeCommand(PersistentCreateNameSchemeCommand createNameSchemeCommand) throws PersistenceException;
    
}
