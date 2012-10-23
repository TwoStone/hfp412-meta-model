
package model.visitor;

import persistence.*;

public abstract class ToString$Visitor extends AnythingStandardVisitor{
    
    public abstract void handleServer(PersistentServer server) throws PersistenceException;
    
}
