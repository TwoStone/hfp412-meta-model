
package model.visitor;

import persistence.*;

public interface RemoteExceptionVisitor<E extends model.UserException> {
    
    public void handleServer(PersistentServer server) throws PersistenceException, E;
    
}
