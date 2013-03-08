
package model.visitor;

import persistence.*;

public interface ObsTypeManagerCommandVisitor {
    
    public void handleCreateObsTypeCommand(PersistentCreateObsTypeCommand createObsTypeCommand) throws PersistenceException;
    public void handleDeleteObsTypeCommand(PersistentDeleteObsTypeCommand deleteObsTypeCommand) throws PersistenceException;
    
}
