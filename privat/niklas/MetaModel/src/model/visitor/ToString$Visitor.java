
package model.visitor;

import persistence.*;

public abstract class ToString$Visitor extends AnythingStandardVisitor{
    
    public abstract void handleTypeManager(PersistentTypeManager typeManager) throws PersistenceException;
    public abstract void handleOrMetaType(PersistentOrMetaType orMetaType) throws PersistenceException;
    public abstract void handleAspectManager(PersistentAspectManager aspectManager) throws PersistenceException;
    public abstract void handleMetaAspect(PersistentMetaAspect metaAspect) throws PersistenceException;
    public abstract void handleServer(PersistentServer server) throws PersistenceException;
    public abstract void handleMetaAssociation(PersistentMetaAssociation metaAssociation) throws PersistenceException;
    public abstract void handleAndMetaType(PersistentAndMetaType andMetaType) throws PersistenceException;
    public abstract void handleMetaHierarchy(PersistentMetaHierarchy metaHierarchy) throws PersistenceException;
    public abstract void handleMetaType(PersistentMetaType metaType) throws PersistenceException;
    
}
