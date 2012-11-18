
package model.visitor;
import model.UserException;
import persistence.*;

public interface AnythingReturnExceptionVisitor<R, E extends UserException> extends MComplexTypeReturnExceptionVisitor<R, E> ,CommonDateReturnExceptionVisitor<R, E> ,MBooleanReturnExceptionVisitor<R, E> {
    
    public R handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException, E;
    public R handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException, E;
    public R handleTypeManager(PersistentTypeManager typeManager) throws PersistenceException, E;
    public R handleAspectManager(PersistentAspectManager aspectManager) throws PersistenceException, E;
    public R handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException, E;
    public R handleAddSubTypeCommand(PersistentAddSubTypeCommand addSubTypeCommand) throws PersistenceException, E;
    public R handleServer(PersistentServer server) throws PersistenceException, E;
    public R handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException, E;
    public R handleCreateAspectCommand(PersistentCreateAspectCommand createAspectCommand) throws PersistenceException, E;
    public R handleCreateAtomicTypeCommand(PersistentCreateAtomicTypeCommand createAtomicTypeCommand) throws PersistenceException, E;
    public R handleMAspect(PersistentMAspect mAspect) throws PersistenceException, E;
    public R handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException, E;
    public R handleCreateSubTypeCommand(PersistentCreateSubTypeCommand createSubTypeCommand) throws PersistenceException, E;
    public R handleMBoolean(PersistentMBoolean mBoolean) throws PersistenceException, E;
    
}
