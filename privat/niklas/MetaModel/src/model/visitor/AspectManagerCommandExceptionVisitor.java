
package model.visitor;

import persistence.*;

public interface AspectManagerCommandExceptionVisitor<E extends model.UserException> {
    
    public void handleCreateAspectCommand(PersistentCreateAspectCommand createAspectCommand) throws PersistenceException, E;
    
}
