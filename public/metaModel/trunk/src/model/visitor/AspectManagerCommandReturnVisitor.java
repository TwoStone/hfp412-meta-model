
package model.visitor;

import persistence.*;

public interface AspectManagerCommandReturnVisitor<R> {
    
    public R handleCreateAspectCommand(PersistentCreateAspectCommand createAspectCommand) throws PersistenceException;
    
}
