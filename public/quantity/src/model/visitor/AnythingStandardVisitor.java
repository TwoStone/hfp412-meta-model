
package model.visitor;

import persistence.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException{
        this.standardHandling(errorDisplay);
    }
    public void handleServer(PersistentServer server) throws PersistenceException{
        this.standardHandling(server);
    }
    public void handleFraction(PersistentFraction fraction) throws PersistenceException{
        this.standardHandling(fraction);
    }
    protected abstract void standardHandling(Anything anything) throws PersistenceException;
}
