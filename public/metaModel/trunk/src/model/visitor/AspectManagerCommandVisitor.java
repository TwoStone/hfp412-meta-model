
package model.visitor;

import persistence.*;

public interface AspectManagerCommandVisitor {
    
    public void handleCreateAspectCommand(PersistentCreateAspectCommand createAspectCommand) throws PersistenceException;
    
}
