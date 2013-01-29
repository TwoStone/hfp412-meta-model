
package model.visitor;

import persistence.*;

public interface NameSchemeManagerCommandReturnVisitor<R> {
    
    public R handleCreateNameSchemeCommand(PersistentCreateNameSchemeCommand createNameSchemeCommand) throws PersistenceException;
    public R handleAssignNameSchemeCommand(PersistentAssignNameSchemeCommand assignNameSchemeCommand) throws PersistenceException;
    
}
