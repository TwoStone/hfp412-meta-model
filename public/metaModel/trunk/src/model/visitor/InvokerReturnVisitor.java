
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentServer;

public interface InvokerReturnVisitor<R> {
    
    public R handleServer(PersistentServer server) throws PersistenceException;
    
}
