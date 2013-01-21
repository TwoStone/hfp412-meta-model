
package model.visitor;
import model.UserException;
import persistence.*;

public interface ObjectManagerCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleCreateMObjectCommand(PersistentCreateMObjectCommand createMObjectCommand) throws PersistenceException, E;
    
}
