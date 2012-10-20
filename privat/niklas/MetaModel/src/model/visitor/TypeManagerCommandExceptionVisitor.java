
package model.visitor;

import persistence.*;

public interface TypeManagerCommandExceptionVisitor<E extends model.UserException> {
    
    public void handleCreateTypeCommand(PersistentCreateTypeCommand createTypeCommand) throws PersistenceException, E;
    
}
