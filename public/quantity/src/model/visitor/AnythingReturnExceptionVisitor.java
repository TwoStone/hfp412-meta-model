
package model.visitor;

import persistence.*;

public interface AnythingReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException, E;
    public R handleFraction(PersistentFraction fraction) throws PersistenceException, E;
    public R handleServer(PersistentServer server) throws PersistenceException, E;
    
}
