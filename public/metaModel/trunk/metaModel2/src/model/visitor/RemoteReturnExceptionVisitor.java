
package model.visitor;

import persistence.*;

public interface RemoteReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleServer(PersistentServer server) throws PersistenceException, E;
    
}
