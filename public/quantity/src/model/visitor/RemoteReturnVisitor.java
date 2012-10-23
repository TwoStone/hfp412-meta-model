
package model.visitor;

import persistence.*;

public interface RemoteReturnVisitor<R> {
    
    public R handleServer(PersistentServer server) throws PersistenceException;
    
}
