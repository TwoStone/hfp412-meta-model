
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentServer;

public interface RemoteVisitor {
    
    public void handleServer(PersistentServer server) throws PersistenceException;
    
}
