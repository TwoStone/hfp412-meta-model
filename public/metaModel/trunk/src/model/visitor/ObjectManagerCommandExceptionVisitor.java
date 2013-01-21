
package model.visitor;
import model.UserException;
import persistence.*;

public interface ObjectManagerCommandExceptionVisitor<E extends UserException> {
    
    public void handleCreateMObjectCommand(PersistentCreateMObjectCommand createMObjectCommand) throws PersistenceException, E;
    
}
