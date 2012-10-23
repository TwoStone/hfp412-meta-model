
package model.visitor;

import persistence.*;

public abstract class ToString$Visitor extends AnythingStandardVisitor{
    
    public abstract void handleMProductType(PersistentMProductType mProductType) throws PersistenceException;
    public abstract void handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException;
    public abstract void handleMSumType(PersistentMSumType mSumType) throws PersistenceException;
    public abstract void handleServer(PersistentServer server) throws PersistenceException;
    
}
