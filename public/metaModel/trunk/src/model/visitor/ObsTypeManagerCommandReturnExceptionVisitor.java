
package model.visitor;
import model.UserException;
import persistence.*;

public interface ObsTypeManagerCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleCreateObsTypeCommand(PersistentCreateObsTypeCommand createObsTypeCommand) throws PersistenceException, E;
    public R handleDeleteObsTypeCommand(PersistentDeleteObsTypeCommand deleteObsTypeCommand) throws PersistenceException, E;
    
}
