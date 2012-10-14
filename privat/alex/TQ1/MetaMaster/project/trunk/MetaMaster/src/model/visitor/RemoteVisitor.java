
package model.visitor;

import persistence.*;

public interface RemoteVisitor {
    
    public void handleServer(PersistentServer server) throws PersistenceException;
    
}
