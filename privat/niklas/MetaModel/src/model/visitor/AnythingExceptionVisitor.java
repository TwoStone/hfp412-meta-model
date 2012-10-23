
package model.visitor;

import persistence.*;

public interface AnythingExceptionVisitor<E extends model.UserException> extends NamedEntityExceptionVisitor<E>,CommonDateExceptionVisitor<E>,AbstractMetaTypeExceptionVisitor<E>{
    
    public void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException, E;
    public void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException, E;
    public void handleTypeManager(PersistentTypeManager typeManager) throws PersistenceException, E;
    public void handleAspectManager(PersistentAspectManager aspectManager) throws PersistenceException, E;
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException, E;
    public void handleServer(PersistentServer server) throws PersistenceException, E;
    public void handleCreateAspectCommand(PersistentCreateAspectCommand createAspectCommand) throws PersistenceException, E;
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException, E;
    public void handleCreateTypeCommand(PersistentCreateTypeCommand createTypeCommand) throws PersistenceException, E;
    
}
