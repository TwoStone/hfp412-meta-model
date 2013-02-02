
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentServer;

public interface InvokerReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleServer(PersistentServer server) throws PersistenceException, E;
    
}
