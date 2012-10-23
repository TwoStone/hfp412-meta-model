
package model.visitor;

import persistence.*;

public interface AnythingExceptionVisitor<E extends model.UserException> extends MComplexTypeExceptionVisitor<E>{
    
    public void handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException, E;
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException, E;
    public void handleServer(PersistentServer server) throws PersistenceException, E;
    
}
