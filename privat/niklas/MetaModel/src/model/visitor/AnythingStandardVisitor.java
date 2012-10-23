
package model.visitor;

import persistence.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleCONCNamedEntity(PersistentCONCNamedEntity cONCNamedEntity) throws PersistenceException{
        this.standardHandling(cONCNamedEntity);
    }
    public void handleTypeManager(PersistentTypeManager typeManager) throws PersistenceException{
        this.standardHandling(typeManager);
    }
    public void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException{
        this.standardHandling(commandExecuter);
    }
    public void handleOrMetaType(PersistentOrMetaType orMetaType) throws PersistenceException{
        this.standardHandling(orMetaType);
    }
    public void handleAspectManager(PersistentAspectManager aspectManager) throws PersistenceException{
        this.standardHandling(aspectManager);
    }
    public void handleMetaAspect(PersistentMetaAspect metaAspect) throws PersistenceException{
        this.standardHandling(metaAspect);
    }
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException{
        this.standardHandling(errorDisplay);
    }
    public void handleServer(PersistentServer server) throws PersistenceException{
        this.standardHandling(server);
    }
    public void handleMetaAssociation(PersistentMetaAssociation metaAssociation) throws PersistenceException{
        this.standardHandling(metaAssociation);
    }
    public void handleCreateAspectCommand(PersistentCreateAspectCommand createAspectCommand) throws PersistenceException{
        this.standardHandling(createAspectCommand);
    }
    public void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException{
        this.standardHandling(commandCoordinator);
    }
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException{
        this.standardHandling(commonDate);
    }
    public void handleAndMetaType(PersistentAndMetaType andMetaType) throws PersistenceException{
        this.standardHandling(andMetaType);
    }
    public void handleMetaHierarchy(PersistentMetaHierarchy metaHierarchy) throws PersistenceException{
        this.standardHandling(metaHierarchy);
    }
    public void handleMetaType(PersistentMetaType metaType) throws PersistenceException{
        this.standardHandling(metaType);
    }
    public void handleCreateTypeCommand(PersistentCreateTypeCommand createTypeCommand) throws PersistenceException{
        this.standardHandling(createTypeCommand);
    }
    protected abstract void standardHandling(Anything anything) throws PersistenceException;
}
