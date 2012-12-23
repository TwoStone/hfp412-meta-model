
package model.visitor;
import model.UserException;
import persistence.*;

public interface AnythingReturnExceptionVisitor<R, E extends UserException> extends AbsUnitTypeReturnExceptionVisitor<R, E> ,MComplexTypeReturnExceptionVisitor<R, E> ,AbsQuantityReturnExceptionVisitor<R, E> ,CommonDateReturnExceptionVisitor<R, E> ,AbsUnitReturnExceptionVisitor<R, E> ,MBooleanReturnExceptionVisitor<R, E> {
    
    public R handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException, E;
    public R handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException, E;
    public R handleConversionManager(PersistentConversionManager conversionManager) throws PersistenceException, E;
    public R handleQuantityManager(PersistentQuantityManager quantityManager) throws PersistenceException, E;
    public R handleAssociationManager(PersistentAssociationManager associationManager) throws PersistenceException, E;
    public R handleCreateUnitTypeCommand(PersistentCreateUnitTypeCommand createUnitTypeCommand) throws PersistenceException, E;
    public R handleCreateConversionCommand(PersistentCreateConversionCommand createConversionCommand) throws PersistenceException, E;
    public R handleCreateAspectCommand(PersistentCreateAspectCommand createAspectCommand) throws PersistenceException, E;
    public R handleMAHierarchy(PersistentMAHierarchy mAHierarchy) throws PersistenceException, E;
    public R handleCreateUnitCommand(PersistentCreateUnitCommand createUnitCommand) throws PersistenceException, E;
    public R handleCreateCompUnitCommand(PersistentCreateCompUnitCommand createCompUnitCommand) throws PersistenceException, E;
    public R handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException, E;
    public R handleCreateCompUnitTypeCommand(PersistentCreateCompUnitTypeCommand createCompUnitTypeCommand) throws PersistenceException, E;
    public R handleTypeManager(PersistentTypeManager typeManager) throws PersistenceException, E;
    public R handleUnitTypeManager(PersistentUnitTypeManager unitTypeManager) throws PersistenceException, E;
    public R handleAddDefaultUnitCommand(PersistentAddDefaultUnitCommand addDefaultUnitCommand) throws PersistenceException, E;
    public R handleServer(PersistentServer server) throws PersistenceException, E;
    public R handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException, E;
    public R handleCreateAtomicTypeCommand(PersistentCreateAtomicTypeCommand createAtomicTypeCommand) throws PersistenceException, E;
    public R handleFractionManager(PersistentFractionManager fractionManager) throws PersistenceException, E;
    public R handleConversion(PersistentConversion conversion) throws PersistenceException, E;
    public R handleReference(PersistentReference reference) throws PersistenceException, E;
    public R handleCreateSubTypeCommand(PersistentCreateSubTypeCommand createSubTypeCommand) throws PersistenceException, E;
    public R handleFinishModelingCommand(PersistentFinishModelingCommand finishModelingCommand) throws PersistenceException, E;
    public R handleReferenceType(PersistentReferenceType referenceType) throws PersistenceException, E;
    public R handleCreateHierarchyCommand(PersistentCreateHierarchyCommand createHierarchyCommand) throws PersistenceException, E;
    public R handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException, E;
    public R handleMAssociation(PersistentMAssociation mAssociation) throws PersistenceException, E;
    public R handleCreateQuantityCommand(PersistentCreateQuantityCommand createQuantityCommand) throws PersistenceException, E;
    public R handleCreateAssociationCommand(PersistentCreateAssociationCommand createAssociationCommand) throws PersistenceException, E;
    public R handleMBoolean(PersistentMBoolean mBoolean) throws PersistenceException, E;
    public R handleAddReferenceTypeCommand(PersistentAddReferenceTypeCommand addReferenceTypeCommand) throws PersistenceException, E;
    public R handleFunction(PersistentFunction function) throws PersistenceException, E;
    public R handleAspectManager(PersistentAspectManager aspectManager) throws PersistenceException, E;
    public R handleAddToHierarchyCommand(PersistentAddToHierarchyCommand addToHierarchyCommand) throws PersistenceException, E;
    public R handleAddSubTypeCommand(PersistentAddSubTypeCommand addSubTypeCommand) throws PersistenceException, E;
    public R handleMAspect(PersistentMAspect mAspect) throws PersistenceException, E;
    
}
