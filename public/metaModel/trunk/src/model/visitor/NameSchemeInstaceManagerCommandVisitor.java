
package model.visitor;

import persistence.*;

public interface NameSchemeInstaceManagerCommandVisitor {
    
    public void handleAssignNameCommand(PersistentAssignNameCommand assignNameCommand) throws PersistenceException;
    public void handleCreateInstanceCommand(PersistentCreateInstanceCommand createInstanceCommand) throws PersistenceException;
    
}
