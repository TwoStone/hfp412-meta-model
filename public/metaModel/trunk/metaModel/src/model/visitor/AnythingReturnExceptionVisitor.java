
package model.visitor;

import persistence.*;

public interface AnythingReturnExceptionVisitor<R, E extends model.UserException> extends MComplexTypeReturnExceptionVisitor<R, E> {
    
    public R handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException, E;
    public R handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException, E;
    public R handleServer(PersistentServer server) throws PersistenceException, E;
    
}
