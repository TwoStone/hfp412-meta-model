
package model.visitor;

import persistence.*;

public interface AnythingVisitor extends MComplexTypeVisitor,CommonDateVisitor,MBooleanVisitor{
    
    public void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException;
    public void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException;
    public void handleTypeManager(PersistentTypeManager typeManager) throws PersistenceException;
    public void handleAspectManager(PersistentAspectManager aspectManager) throws PersistenceException;
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public void handleAddSubTypeCommand(PersistentAddSubTypeCommand addSubTypeCommand) throws PersistenceException;
    public void handleServer(PersistentServer server) throws PersistenceException;
    public void handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException;
    public void handleCreateAspectCommand(PersistentCreateAspectCommand createAspectCommand) throws PersistenceException;
    public void handleCreateAtomicTypeCommand(PersistentCreateAtomicTypeCommand createAtomicTypeCommand) throws PersistenceException;
    public void handleMAspect(PersistentMAspect mAspect) throws PersistenceException;
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    public void handleCreateSubTypeCommand(PersistentCreateSubTypeCommand createSubTypeCommand) throws PersistenceException;
    public void handleMBoolean(PersistentMBoolean mBoolean) throws PersistenceException;
    
}
