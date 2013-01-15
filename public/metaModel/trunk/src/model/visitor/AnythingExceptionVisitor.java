
package model.visitor;
import model.UserException;
import persistence.*;

public interface AnythingExceptionVisitor<E extends UserException> extends AbsUnitTypeExceptionVisitor<E>,MComplexTypeExceptionVisitor<E>,AbsQuantityExceptionVisitor<E>,CommonDateExceptionVisitor<E>,AbsUnitExceptionVisitor<E>,MQuantiObjectTypeExceptionVisitor<E>,MessageOrLinkExceptionVisitor<E>,MAbsOperationExceptionVisitor<E>,MBooleanExceptionVisitor<E>{
    
    public void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException, E;
    public void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException, E;
    public void handleConversionManager(PersistentConversionManager conversionManager) throws PersistenceException, E;
    public void handleQuantityManager(PersistentQuantityManager quantityManager) throws PersistenceException, E;
    public void handleCreateUnitTypeCommand(PersistentCreateUnitTypeCommand createUnitTypeCommand) throws PersistenceException, E;
    public void handleAssociationManager(PersistentAssociationManager associationManager) throws PersistenceException, E;
    public void handleCreateConversionCommand(PersistentCreateConversionCommand createConversionCommand) throws PersistenceException, E;
    public void handleCreateAspectCommand(PersistentCreateAspectCommand createAspectCommand) throws PersistenceException, E;
    public void handleCreateUnitCommand(PersistentCreateUnitCommand createUnitCommand) throws PersistenceException, E;
    public void handleMAHierarchy(PersistentMAHierarchy mAHierarchy) throws PersistenceException, E;
    public void handleCreateCompUnitCommand(PersistentCreateCompUnitCommand createCompUnitCommand) throws PersistenceException, E;
    public void handleCreateCompUnitTypeCommand(PersistentCreateCompUnitTypeCommand createCompUnitTypeCommand) throws PersistenceException, E;
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException, E;
    public void handleTypeManager(PersistentTypeManager typeManager) throws PersistenceException, E;
    public void handleUnitTypeManager(PersistentUnitTypeManager unitTypeManager) throws PersistenceException, E;
    public void handleAddDefaultUnitCommand(PersistentAddDefaultUnitCommand addDefaultUnitCommand) throws PersistenceException, E;
    public void handleServer(PersistentServer server) throws PersistenceException, E;
    public void handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException, E;
    public void handleCreateAtomicTypeCommand(PersistentCreateAtomicTypeCommand createAtomicTypeCommand) throws PersistenceException, E;
    public void handleFractionManager(PersistentFractionManager fractionManager) throws PersistenceException, E;
    public void handleConversion(PersistentConversion conversion) throws PersistenceException, E;
    public void handleReference(PersistentReference reference) throws PersistenceException, E;
    public void handleCreateSubTypeCommand(PersistentCreateSubTypeCommand createSubTypeCommand) throws PersistenceException, E;
    public void handleMeasurement(PersistentMeasurement measurement) throws PersistenceException, E;
    public void handleFinishModelingCommand(PersistentFinishModelingCommand finishModelingCommand) throws PersistenceException, E;
    public void handleReferenceType(PersistentReferenceType referenceType) throws PersistenceException, E;
    public void handleAccount(PersistentAccount account) throws PersistenceException, E;
    public void handleCreateHierarchyCommand(PersistentCreateHierarchyCommand createHierarchyCommand) throws PersistenceException, E;
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException, E;
    public void handleMFormalParameter(PersistentMFormalParameter mFormalParameter) throws PersistenceException, E;
    public void handleMAssociation(PersistentMAssociation mAssociation) throws PersistenceException, E;
    public void handleCreateAssociationCommand(PersistentCreateAssociationCommand createAssociationCommand) throws PersistenceException, E;
    public void handleCreateQuantityCommand(PersistentCreateQuantityCommand createQuantityCommand) throws PersistenceException, E;
    public void handleInstanceObject(PersistentInstanceObject instanceObject) throws PersistenceException, E;
    public void handleAddReferenceTypeCommand(PersistentAddReferenceTypeCommand addReferenceTypeCommand) throws PersistenceException, E;
    public void handleFunction(PersistentFunction function) throws PersistenceException, E;
    public void handleAspectManager(PersistentAspectManager aspectManager) throws PersistenceException, E;
    public void handleActualParameter(PersistentActualParameter actualParameter) throws PersistenceException, E;
    public void handleAddToHierarchyCommand(PersistentAddToHierarchyCommand addToHierarchyCommand) throws PersistenceException, E;
    public void handleAddSubTypeCommand(PersistentAddSubTypeCommand addSubTypeCommand) throws PersistenceException, E;
    public void handleMAspect(PersistentMAspect mAspect) throws PersistenceException, E;
    
}
