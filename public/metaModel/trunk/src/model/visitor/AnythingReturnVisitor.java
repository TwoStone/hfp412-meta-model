
package model.visitor;

import persistence.*;

public interface AnythingReturnVisitor<R> extends AbsUnitTypeReturnVisitor<R> ,MComplexTypeReturnVisitor<R> ,AbsQuantityReturnVisitor<R> ,CommonDateReturnVisitor<R> ,AbsUnitReturnVisitor<R> ,MBooleanReturnVisitor<R> {
    
    public R handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException;
    public R handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException;
    public R handleConversionManager(PersistentConversionManager conversionManager) throws PersistenceException;
    public R handleQuantityManager(PersistentQuantityManager quantityManager) throws PersistenceException;
    public R handleCreateUnitTypeCommand(PersistentCreateUnitTypeCommand createUnitTypeCommand) throws PersistenceException;
    public R handleAssociationManager(PersistentAssociationManager associationManager) throws PersistenceException;
    public R handleCreateConversionCommand(PersistentCreateConversionCommand createConversionCommand) throws PersistenceException;
    public R handleCreateAspectCommand(PersistentCreateAspectCommand createAspectCommand) throws PersistenceException;
    public R handleMAHierarchy(PersistentMAHierarchy mAHierarchy) throws PersistenceException;
    public R handleCreateUnitCommand(PersistentCreateUnitCommand createUnitCommand) throws PersistenceException;
    public R handleCreateCompUnitCommand(PersistentCreateCompUnitCommand createCompUnitCommand) throws PersistenceException;
    public R handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    public R handleCreateCompUnitTypeCommand(PersistentCreateCompUnitTypeCommand createCompUnitTypeCommand) throws PersistenceException;
    public R handleTypeManager(PersistentTypeManager typeManager) throws PersistenceException;
    public R handleUnitTypeManager(PersistentUnitTypeManager unitTypeManager) throws PersistenceException;
    public R handleAddDefaultUnitCommand(PersistentAddDefaultUnitCommand addDefaultUnitCommand) throws PersistenceException;
    public R handleServer(PersistentServer server) throws PersistenceException;
    public R handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException;
    public R handleCreateAtomicTypeCommand(PersistentCreateAtomicTypeCommand createAtomicTypeCommand) throws PersistenceException;
    public R handleFractionManager(PersistentFractionManager fractionManager) throws PersistenceException;
    public R handleConversion(PersistentConversion conversion) throws PersistenceException;
    public R handleReference(PersistentReference reference) throws PersistenceException;
    public R handleCreateSubTypeCommand(PersistentCreateSubTypeCommand createSubTypeCommand) throws PersistenceException;
    public R handleFinishModelingCommand(PersistentFinishModelingCommand finishModelingCommand) throws PersistenceException;
    public R handleReferenceType(PersistentReferenceType referenceType) throws PersistenceException;
    public R handleCreateHierarchyCommand(PersistentCreateHierarchyCommand createHierarchyCommand) throws PersistenceException;
    public R handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public R handleMAssociation(PersistentMAssociation mAssociation) throws PersistenceException;
    public R handleCreateQuantityCommand(PersistentCreateQuantityCommand createQuantityCommand) throws PersistenceException;
    public R handleCreateAssociationCommand(PersistentCreateAssociationCommand createAssociationCommand) throws PersistenceException;
    public R handleAddReferenceTypeCommand(PersistentAddReferenceTypeCommand addReferenceTypeCommand) throws PersistenceException;
    public R handleFunction(PersistentFunction function) throws PersistenceException;
    public R handleAspectManager(PersistentAspectManager aspectManager) throws PersistenceException;
    public R handleAddToHierarchyCommand(PersistentAddToHierarchyCommand addToHierarchyCommand) throws PersistenceException;
    public R handleAddSubTypeCommand(PersistentAddSubTypeCommand addSubTypeCommand) throws PersistenceException;
    public R handleMAspect(PersistentMAspect mAspect) throws PersistenceException;
    
}
