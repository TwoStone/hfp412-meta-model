
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentCreateAspectCommand;

public interface AspectManagerCommandVisitor {
    
    public void handleCreateAspectCommand(PersistentCreateAspectCommand createAspectCommand) throws PersistenceException;
    
}
