
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentServer;

public interface InvokerVisitor {
    
    public void handleServer(PersistentServer server) throws PersistenceException;
    
}
