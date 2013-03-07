
package model.visitor;
import model.UserException;
import persistence.*;

public interface RemoteExceptionVisitor<E extends UserException> {
    
    public void handleServer(PersistentServer server) throws PersistenceException, E;
    
}
