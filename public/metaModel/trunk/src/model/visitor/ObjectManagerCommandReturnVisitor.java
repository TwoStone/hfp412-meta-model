
package model.visitor;

import persistence.*;

public interface ObjectManagerCommandReturnVisitor<R> {
    
    public R handleCreateMObjectCommand(PersistentCreateMObjectCommand createMObjectCommand) throws PersistenceException;
    
}
