
package model.visitor;

import persistence.*;

public interface AnythingReturnVisitor<R> {
    
    public R handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public R handleServer(PersistentServer server) throws PersistenceException;
    
}
