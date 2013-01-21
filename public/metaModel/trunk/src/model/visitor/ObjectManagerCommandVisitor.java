
package model.visitor;

import persistence.*;

public interface ObjectManagerCommandVisitor {
    
    public void handleCreateMObjectCommand(PersistentCreateMObjectCommand createMObjectCommand) throws PersistenceException;
    
}
