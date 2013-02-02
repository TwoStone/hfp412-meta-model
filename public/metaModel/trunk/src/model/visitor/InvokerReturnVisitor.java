
package model.visitor;

import persistence.*;

public interface InvokerReturnVisitor<R> {
    
    public R handleServer(PersistentServer server) throws PersistenceException;
    
}
