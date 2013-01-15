
package model.visitor;

import persistence.*;

public interface AnythingVisitor extends AbsUnitTypeVisitor,AbsQuantityVisitor,CommonDateVisitor,MTypeVisitor,AbsUnitVisitor,MQuantiObjectTypeVisitor,MessageOrLinkVisitor,MAbsOperationVisitor,MBooleanVisitor{
    
    public void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException;
    public void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException;
    public void handleConversionManager(PersistentConversionManager conversionManager) throws PersistenceException;
    public void handleQuantityManager(PersistentQuantityManager quantityManager) throws PersistenceException;
    public void handleCreateProductTypeCommand(PersistentCreateProductTypeCommand createProductTypeCommand) throws PersistenceException;
    public void handleCreateUnitTypeCommand(PersistentCreateUnitTypeCommand createUnitTypeCommand) throws PersistenceException;
    public void handleAssociationManager(PersistentAssociationManager associationManager) throws PersistenceException;
    public void handleCreateConversionCommand(PersistentCreateConversionCommand createConversionCommand) throws PersistenceException;
    public void handleCreateAtomicSubTypeCommand(PersistentCreateAtomicSubTypeCommand createAtomicSubTypeCommand) throws PersistenceException;
    public void handleCreateAspectCommand(PersistentCreateAspectCommand createAspectCommand) throws PersistenceException;
    public void handleCreateUnitCommand(PersistentCreateUnitCommand createUnitCommand) throws PersistenceException;
    public void handleMAHierarchy(PersistentMAHierarchy mAHierarchy) throws PersistenceException;
    public void handleCreateCompUnitCommand(PersistentCreateCompUnitCommand createCompUnitCommand) throws PersistenceException;
    public void handleCreateCompUnitTypeCommand(PersistentCreateCompUnitTypeCommand createCompUnitTypeCommand) throws PersistenceException;
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    public void handleTypeManager(PersistentTypeManager typeManager) throws PersistenceException;
    public void handleUnitTypeManager(PersistentUnitTypeManager unitTypeManager) throws PersistenceException;
    public void handleAddDefaultUnitCommand(PersistentAddDefaultUnitCommand addDefaultUnitCommand) throws PersistenceException;
    public void handleServer(PersistentServer server) throws PersistenceException;
    public void handleFractionManager(PersistentFractionManager fractionManager) throws PersistenceException;
    public void handleReference(PersistentReference reference) throws PersistenceException;
    public void handleConversion(PersistentConversion conversion) throws PersistenceException;
    public void handleMeasurement(PersistentMeasurement measurement) throws PersistenceException;
    public void handleFinishModelingCommand(PersistentFinishModelingCommand finishModelingCommand) throws PersistenceException;
    public void handleReferenceType(PersistentReferenceType referenceType) throws PersistenceException;
    public void handleAccount(PersistentAccount account) throws PersistenceException;
    public void handleCreateHierarchyCommand(PersistentCreateHierarchyCommand createHierarchyCommand) throws PersistenceException;
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public void handleMFormalParameter(PersistentMFormalParameter mFormalParameter) throws PersistenceException;
    public void handleMAssociation(PersistentMAssociation mAssociation) throws PersistenceException;
    public void handleCreateAssociationCommand(PersistentCreateAssociationCommand createAssociationCommand) throws PersistenceException;
    public void handleCreateQuantityCommand(PersistentCreateQuantityCommand createQuantityCommand) throws PersistenceException;
    public void handleInstanceObject(PersistentInstanceObject instanceObject) throws PersistenceException;
    public void handleCreateAtomicRootTypeCommand(PersistentCreateAtomicRootTypeCommand createAtomicRootTypeCommand) throws PersistenceException;
    public void handleAddReferenceTypeCommand(PersistentAddReferenceTypeCommand addReferenceTypeCommand) throws PersistenceException;
    public void handleFunction(PersistentFunction function) throws PersistenceException;
    public void handleAspectManager(PersistentAspectManager aspectManager) throws PersistenceException;
    public void handleActualParameter(PersistentActualParameter actualParameter) throws PersistenceException;
    public void handleAddToHierarchyCommand(PersistentAddToHierarchyCommand addToHierarchyCommand) throws PersistenceException;
    public void handleAddSubTypeCommand(PersistentAddSubTypeCommand addSubTypeCommand) throws PersistenceException;
    public void handleCreateSumTypeCommand(PersistentCreateSumTypeCommand createSumTypeCommand) throws PersistenceException;
    public void handleMAspect(PersistentMAspect mAspect) throws PersistenceException;
    
}
