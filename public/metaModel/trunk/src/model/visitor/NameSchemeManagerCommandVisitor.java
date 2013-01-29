
package model.visitor;

import persistence.*;

public interface NameSchemeManagerCommandVisitor {
    
    public void handleCreateNameSchemeCommand(PersistentCreateNameSchemeCommand createNameSchemeCommand) throws PersistenceException;
    public void handleAssignNameSchemeCommand(PersistentAssignNameSchemeCommand assignNameSchemeCommand) throws PersistenceException;
    
}
