
package model.visitor;

import persistence.*;

public interface AnythingReturnVisitor<R> extends CommonDateReturnVisitor<R> ,MComplexTypeReturnVisitor<R> {
    
    public R handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException;
    public R handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException;
    public R handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException;
    public R handleTypeManager(PersistentTypeManager typeManager) throws PersistenceException;
    public R handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    public R handleAddAtomicTypeCommand(PersistentAddAtomicTypeCommand addAtomicTypeCommand) throws PersistenceException;
    public R handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public R handleServer(PersistentServer server) throws PersistenceException;
    
}
