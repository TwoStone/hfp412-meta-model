
package model.visitor;

import persistence.*;

public interface InvokerVisitor {
    
    public void handleServer(PersistentServer server) throws PersistenceException;
    
}
