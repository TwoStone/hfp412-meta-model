
package model.visitor;

import persistence.*;

public interface AnythingVisitor extends MComplexTypeVisitor{
    
    public void handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException;
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public void handleServer(PersistentServer server) throws PersistenceException;
    
}
