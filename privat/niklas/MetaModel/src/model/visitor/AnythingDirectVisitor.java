
package model.visitor;

import persistence.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleTypeManager(PersistentTypeManager typeManager) throws PersistenceException;
    
    public abstract void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException;
    
    public abstract void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException;
    
    public abstract void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    
    public void handleCreateAspectCommand(PersistentCreateAspectCommand createAspectCommand) throws PersistenceException{
        this.handleCommonDate(createAspectCommand);
    }
    public void handleCreateTypeCommand(PersistentCreateTypeCommand createTypeCommand) throws PersistenceException{
        this.handleCommonDate(createTypeCommand);
    }
    public abstract void handleAspectManager(PersistentAspectManager aspectManager) throws PersistenceException;
    
    public abstract void handleAbstractMetaType(PersistentAbstractMetaType abstractMetaType) throws PersistenceException;
    
    public void handleOrMetaType(PersistentOrMetaType orMetaType) throws PersistenceException{
        this.handleAbstractMetaType(orMetaType);
    }
    public void handleAndMetaType(PersistentAndMetaType andMetaType) throws PersistenceException{
        this.handleAbstractMetaType(andMetaType);
    }
    public void handleMetaType(PersistentMetaType metaType) throws PersistenceException{
        this.handleAbstractMetaType(metaType);
    }
    public abstract void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    
    public abstract void handleNamedEntity(PersistentNamedEntity namedEntity) throws PersistenceException;
    
    public void handleCONCNamedEntity(PersistentCONCNamedEntity cONCNamedEntity) throws PersistenceException{
        this.handleNamedEntity(cONCNamedEntity);
    }
    public void handleMetaAspect(PersistentMetaAspect metaAspect) throws PersistenceException{
        this.handleNamedEntity(metaAspect);
    }
    public void handleMetaHierarchy(PersistentMetaHierarchy metaHierarchy) throws PersistenceException{
        this.handleNamedEntity(metaHierarchy);
    }
    public void handleMetaAssociation(PersistentMetaAssociation metaAssociation) throws PersistenceException{
        this.handleNamedEntity(metaAssociation);
    }
    public abstract void handleServer(PersistentServer server) throws PersistenceException;
    
    
}
