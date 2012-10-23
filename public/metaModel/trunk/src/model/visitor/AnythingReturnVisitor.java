
package model.visitor;

import persistence.*;

public interface AnythingReturnVisitor<R> extends MComplexTypeReturnVisitor<R> {
    
    public R handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException;
    public R handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public R handleServer(PersistentServer server) throws PersistenceException;
    
}
