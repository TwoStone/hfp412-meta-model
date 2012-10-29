
package model.visitor;

import persistence.*;

public interface AnythingVisitor extends MComplexTypeVisitor,CommonDateVisitor{
    
    public void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException;
    public void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException;
    public void handleTypeManager(PersistentTypeManager typeManager) throws PersistenceException;
    public void handleAddAspectCommand(PersistentAddAspectCommand addAspectCommand) throws PersistenceException;
    public void handleAspectManager(PersistentAspectManager aspectManager) throws PersistenceException;
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public void handleServer(PersistentServer server) throws PersistenceException;
    public void handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException;
    public void handleMAspect(PersistentMAspect mAspect) throws PersistenceException;
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    public void handleAddAtomicTypeCommand(PersistentAddAtomicTypeCommand addAtomicTypeCommand) throws PersistenceException;
    
}
