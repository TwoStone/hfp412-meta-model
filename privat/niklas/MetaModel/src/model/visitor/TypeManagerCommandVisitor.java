
package model.visitor;

import persistence.*;

public interface TypeManagerCommandVisitor {
    
    public void handleCreateTypeCommand(PersistentCreateTypeCommand createTypeCommand) throws PersistenceException;
    
}
