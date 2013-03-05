
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentServer;

public interface InvokerExceptionVisitor<E extends UserException> {
    
    public void handleServer(PersistentServer server) throws PersistenceException, E;
    
}
