
package model.visitor;

import persistence.*;

public interface ObsTypeManagerCommandReturnVisitor<R> {
    
    public R handleCreateObsTypeCommand(PersistentCreateObsTypeCommand createObsTypeCommand) throws PersistenceException;
    public R handleDeleteObsTypeCommand(PersistentDeleteObsTypeCommand deleteObsTypeCommand) throws PersistenceException;
    
}
