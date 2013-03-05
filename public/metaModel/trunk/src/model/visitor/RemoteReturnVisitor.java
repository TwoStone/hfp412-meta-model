
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentServer;

public interface RemoteReturnVisitor<R> {
    
    public R handleServer(PersistentServer server) throws PersistenceException;
    
}
