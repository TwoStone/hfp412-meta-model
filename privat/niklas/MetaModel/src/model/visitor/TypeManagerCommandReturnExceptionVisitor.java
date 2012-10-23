
package model.visitor;

import persistence.*;

public interface TypeManagerCommandReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleCreateTypeCommand(PersistentCreateTypeCommand createTypeCommand) throws PersistenceException, E;
    
}
