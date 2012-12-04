
package model.visitor;

import persistence.*;

public interface QuantityManagerCommandReturnVisitor<R> {
    
    public R handleCreateQuantityCommand(PersistentCreateQuantityCommand createQuantityCommand) throws PersistenceException;
    
}
