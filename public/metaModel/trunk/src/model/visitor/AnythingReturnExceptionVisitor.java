
package model.visitor;
import model.UserException;
import persistence.*;

public interface AnythingReturnExceptionVisitor<R, E extends UserException> extends CommonDateReturnExceptionVisitor<R, E> ,MComplexTypeReturnExceptionVisitor<R, E> {
    
    public R handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException, E;
    public R handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException, E;
    public R handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException, E;
    public R handleTypeManager(PersistentTypeManager typeManager) throws PersistenceException, E;
    public R handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException, E;
    public R handleAddAtomicTypeCommand(PersistentAddAtomicTypeCommand addAtomicTypeCommand) throws PersistenceException, E;
    public R handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException, E;
    public R handleServer(PersistentServer server) throws PersistenceException, E;
    
}
