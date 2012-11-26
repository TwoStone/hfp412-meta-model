
package model.visitor;
import model.UserException;
import persistence.*;

public interface AnythingExceptionVisitor<E extends UserException> extends MComplexTypeExceptionVisitor<E>,CommonDateExceptionVisitor<E>,MBooleanExceptionVisitor<E>{
    
    public void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException, E;
    public void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException, E;
    public void handleTypeManager(PersistentTypeManager typeManager) throws PersistenceException, E;
    public void handleCreateHierarchyCommand(PersistentCreateHierarchyCommand createHierarchyCommand) throws PersistenceException, E;
    public void handleAspectManager(PersistentAspectManager aspectManager) throws PersistenceException, E;
    public void handleAddToHierarchyCommand(PersistentAddToHierarchyCommand addToHierarchyCommand) throws PersistenceException, E;
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException, E;
    public void handleAddSubTypeCommand(PersistentAddSubTypeCommand addSubTypeCommand) throws PersistenceException, E;
    public void handleServer(PersistentServer server) throws PersistenceException, E;
    public void handleAssociationManager(PersistentAssociationManager associationManager) throws PersistenceException, E;
    public void handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException, E;
    public void handleCreateAspectCommand(PersistentCreateAspectCommand createAspectCommand) throws PersistenceException, E;
    public void handleCreateAtomicTypeCommand(PersistentCreateAtomicTypeCommand createAtomicTypeCommand) throws PersistenceException, E;
    public void handleMAHierarchy(PersistentMAHierarchy mAHierarchy) throws PersistenceException, E;
    public void handleMAspect(PersistentMAspect mAspect) throws PersistenceException, E;
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException, E;
    public void handleMAssociation(PersistentMAssociation mAssociation) throws PersistenceException, E;
    public void handleCreateAssociationCommand(PersistentCreateAssociationCommand createAssociationCommand) throws PersistenceException, E;
    public void handleCreateSubTypeCommand(PersistentCreateSubTypeCommand createSubTypeCommand) throws PersistenceException, E;
    public void handleMBoolean(PersistentMBoolean mBoolean) throws PersistenceException, E;
    
}
