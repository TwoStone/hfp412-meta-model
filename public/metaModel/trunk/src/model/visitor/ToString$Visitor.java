
package model.visitor;

import persistence.*;

public abstract class ToString$Visitor extends AnythingStandardVisitor{
    
    public abstract void handleMProductType(PersistentMProductType mProductType) throws PersistenceException;
    public abstract void handleTypeManager(PersistentTypeManager typeManager) throws PersistenceException;
    public abstract void handleAspectManager(PersistentAspectManager aspectManager) throws PersistenceException;
    public abstract void handleServer(PersistentServer server) throws PersistenceException;
    public abstract void handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException;
    public abstract void handleMAspect(PersistentMAspect mAspect) throws PersistenceException;
    public abstract void handleMSumType(PersistentMSumType mSumType) throws PersistenceException;
    
}
