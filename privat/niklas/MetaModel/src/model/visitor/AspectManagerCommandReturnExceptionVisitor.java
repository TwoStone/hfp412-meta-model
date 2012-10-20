
package model.visitor;

import persistence.*;

public interface AspectManagerCommandReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleCreateAspectCommand(PersistentCreateAspectCommand createAspectCommand) throws PersistenceException, E;
    
}
