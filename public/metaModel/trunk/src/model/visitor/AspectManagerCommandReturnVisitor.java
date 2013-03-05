
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentCreateAspectCommand;

public interface AspectManagerCommandReturnVisitor<R> {
    
    public R handleCreateAspectCommand(PersistentCreateAspectCommand createAspectCommand) throws PersistenceException;
    
}
