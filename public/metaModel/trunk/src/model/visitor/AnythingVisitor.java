
package model.visitor;

import persistence.*;

public interface AnythingVisitor extends CommonDateVisitor,MComplexTypeVisitor{
    
    public void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException;
    public void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException;
    public void handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException;
    public void handleTypeManager(PersistentTypeManager typeManager) throws PersistenceException;
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    public void handleAddAtomicTypeCommand(PersistentAddAtomicTypeCommand addAtomicTypeCommand) throws PersistenceException;
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public void handleServer(PersistentServer server) throws PersistenceException;
    
}
