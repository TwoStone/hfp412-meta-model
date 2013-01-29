
package model.visitor;

import persistence.*;

public interface NameSchemeInstaceManagerCommandReturnVisitor<R> {
    
    public R handleAssignNameCommand(PersistentAssignNameCommand assignNameCommand) throws PersistenceException;
    public R handleCreateInstanceCommand(PersistentCreateInstanceCommand createInstanceCommand) throws PersistenceException;
    
}
