
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentServer;
import persistence.Remote;

public abstract class RemoteStandardVisitor implements RemoteVisitor {
    
    public void handleServer(PersistentServer server) throws PersistenceException{
        this.standardHandling(server);
    }
    protected abstract void standardHandling(Remote remote) throws PersistenceException;
}
