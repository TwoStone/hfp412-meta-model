
package model.visitor;
import model.UserException;
import persistence.*;

public interface AnythingExceptionVisitor<E extends UserException> extends CommonDateExceptionVisitor<E>,MComplexTypeExceptionVisitor<E>{
    
    public void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException, E;
    public void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException, E;
    public void handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException, E;
    public void handleTypeManager(PersistentTypeManager typeManager) throws PersistenceException, E;
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException, E;
    public void handleAddAtomicTypeCommand(PersistentAddAtomicTypeCommand addAtomicTypeCommand) throws PersistenceException, E;
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException, E;
    public void handleServer(PersistentServer server) throws PersistenceException, E;
    
}
