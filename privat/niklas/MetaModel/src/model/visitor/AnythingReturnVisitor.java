
package model.visitor;

import persistence.*;

public interface AnythingReturnVisitor<R> extends NamedEntityReturnVisitor<R> ,CommonDateReturnVisitor<R> ,AbstractMetaTypeReturnVisitor<R> {
    
    public R handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException;
    public R handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException;
    public R handleTypeManager(PersistentTypeManager typeManager) throws PersistenceException;
    public R handleAspectManager(PersistentAspectManager aspectManager) throws PersistenceException;
    public R handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public R handleServer(PersistentServer server) throws PersistenceException;
    public R handleCreateAspectCommand(PersistentCreateAspectCommand createAspectCommand) throws PersistenceException;
    public R handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    public R handleCreateTypeCommand(PersistentCreateTypeCommand createTypeCommand) throws PersistenceException;
    
}
