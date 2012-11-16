
package model.visitor;

import persistence.*;

public interface AnythingReturnVisitor<R> extends MComplexTypeReturnVisitor<R> ,CommonDateReturnVisitor<R> ,MBooleanReturnVisitor<R> {
    
    public R handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException;
    public R handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException;
    public R handleTypeManager(PersistentTypeManager typeManager) throws PersistenceException;
    public R handleAddAspectCommand(PersistentAddAspectCommand addAspectCommand) throws PersistenceException;
    public R handleAspectManager(PersistentAspectManager aspectManager) throws PersistenceException;
    public R handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public R handleAddSubTypeCommand(PersistentAddSubTypeCommand addSubTypeCommand) throws PersistenceException;
    public R handleServer(PersistentServer server) throws PersistenceException;
    public R handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException;
    public R handleMAspect(PersistentMAspect mAspect) throws PersistenceException;
    public R handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    public R handleAddAtomicTypeCommand(PersistentAddAtomicTypeCommand addAtomicTypeCommand) throws PersistenceException;
    public R handleCreateSubTypeCommand(PersistentCreateSubTypeCommand createSubTypeCommand) throws PersistenceException;
    public R handleMBoolean(PersistentMBoolean mBoolean) throws PersistenceException;
    
}
