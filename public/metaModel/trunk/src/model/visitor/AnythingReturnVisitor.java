
package model.visitor;

import persistence.*;

public interface AnythingReturnVisitor<R> extends AbstractObjectReturnVisitor<R> ,AbsOperationReturnVisitor<R> ,QuantifObjectReturnVisitor<R> ,MQuantiObjectTypeReturnVisitor<R> ,MModelItemReturnVisitor<R> ,MBooleanReturnVisitor<R> ,BasicCalculationReturnVisitor<R> ,AbsUnitTypeReturnVisitor<R> ,AbsQuantityReturnVisitor<R> ,CommonDateReturnVisitor<R> ,MTypeReturnVisitor<R> ,AbsUnitReturnVisitor<R> ,MessageOrLinkReturnVisitor<R> {
    
    public R handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException;
    public R handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException;
    public R handleMEnum(PersistentMEnum mEnum) throws PersistenceException;
    public R handleConvertToDefaultCommand(PersistentConvertToDefaultCommand convertToDefaultCommand) throws PersistenceException;
    public R handleCreateEnumCommand(PersistentCreateEnumCommand createEnumCommand) throws PersistenceException;
    public R handleCreateMObjectCommand(PersistentCreateMObjectCommand createMObjectCommand) throws PersistenceException;
    public R handleAddTypeCommand(PersistentAddTypeCommand addTypeCommand) throws PersistenceException;
    public R handleAssignTypeCommand(PersistentAssignTypeCommand assignTypeCommand) throws PersistenceException;
    public R handleMinStrategy(PersistentMinStrategy minStrategy) throws PersistenceException;
    public R handleCreateUnitTypeCommand(PersistentCreateUnitTypeCommand createUnitTypeCommand) throws PersistenceException;
    public R handleRemoveUnitTypeCommand(PersistentRemoveUnitTypeCommand removeUnitTypeCommand) throws PersistenceException;
    public R handleRemoveHierarchyCommand(PersistentRemoveHierarchyCommand removeHierarchyCommand) throws PersistenceException;
    public R handleCreateAspectCommand(PersistentCreateAspectCommand createAspectCommand) throws PersistenceException;
    public R handleCreateUnitCommand(PersistentCreateUnitCommand createUnitCommand) throws PersistenceException;
    public R handleNameSchemeInstance(PersistentNameSchemeInstance nameSchemeInstance) throws PersistenceException;
    public R handleCreateTypeDisjunctionCommand(PersistentCreateTypeDisjunctionCommand createTypeDisjunctionCommand) throws PersistenceException;
    public R handleRemoveTypeCommand(PersistentRemoveTypeCommand removeTypeCommand) throws PersistenceException;
    public R handleRemoveAssoFrmHierCommand(PersistentRemoveAssoFrmHierCommand removeAssoFrmHierCommand) throws PersistenceException;
    public R handleSetConversionCommand(PersistentSetConversionCommand setConversionCommand) throws PersistenceException;
    public R handleServer(PersistentServer server) throws PersistenceException;
    public R handleNameScheme(PersistentNameScheme nameScheme) throws PersistenceException;
    public R handleCreateTypeConjunctionCommand(PersistentCreateTypeConjunctionCommand createTypeConjunctionCommand) throws PersistenceException;
    public R handleAssignNameCommand(PersistentAssignNameCommand assignNameCommand) throws PersistenceException;
    public R handleAggregateCommand(PersistentAggregateCommand aggregateCommand) throws PersistenceException;
    public R handleAddSubAccountTypeCommand(PersistentAddSubAccountTypeCommand addSubAccountTypeCommand) throws PersistenceException;
    public R handleRemoveLinkCommand(PersistentRemoveLinkCommand removeLinkCommand) throws PersistenceException;
    public R handleMObservationType(PersistentMObservationType mObservationType) throws PersistenceException;
    public R handleFormalParameter(PersistentFormalParameter formalParameter) throws PersistenceException;
    public R handleCreateHierarchyCommand(PersistentCreateHierarchyCommand createHierarchyCommand) throws PersistenceException;
    public R handleOperationManager(PersistentOperationManager operationManager) throws PersistenceException;
    public R handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public R handleMulCommand(PersistentMulCommand mulCommand) throws PersistenceException;
    public R handleCreateMeasurementTypeCommand(PersistentCreateMeasurementTypeCommand createMeasurementTypeCommand) throws PersistenceException;
    public R handleAccountTypeManager(PersistentAccountTypeManager accountTypeManager) throws PersistenceException;
    public R handleMObservation(PersistentMObservation mObservation) throws PersistenceException;
    public R handleCreateQuantityCommand(PersistentCreateQuantityCommand createQuantityCommand) throws PersistenceException;
    public R handleRemoveFpCommand(PersistentRemoveFpCommand removeFpCommand) throws PersistenceException;
    public R handleGetExistingCUTCommand(PersistentGetExistingCUTCommand getExistingCUTCommand) throws PersistenceException;
    public R handleFetchScalarCommand(PersistentFetchScalarCommand fetchScalarCommand) throws PersistenceException;
    public R handleNameInstance(PersistentNameInstance nameInstance) throws PersistenceException;
    public R handleDeleteEnumCommand(PersistentDeleteEnumCommand deleteEnumCommand) throws PersistenceException;
    public R handleFunction(PersistentFunction function) throws PersistenceException;
    public R handleAspectManager(PersistentAspectManager aspectManager) throws PersistenceException;
    public R handleRemoveOperationCommand(PersistentRemoveOperationCommand removeOperationCommand) throws PersistenceException;
    public R handleCreateConstantCommand(PersistentCreateConstantCommand createConstantCommand) throws PersistenceException;
    public R handleAddReferenceCommand(PersistentAddReferenceCommand addReferenceCommand) throws PersistenceException;
    public R handleMAspect(PersistentMAspect mAspect) throws PersistenceException;
    public R handleCreateNameSchemeCommand(PersistentCreateNameSchemeCommand createNameSchemeCommand) throws PersistenceException;
    public R handleAccountManager(PersistentAccountManager accountManager) throws PersistenceException;
    public R handleAddEntryCommand(PersistentAddEntryCommand addEntryCommand) throws PersistenceException;
    public R handleCreateMessageCommand(PersistentCreateMessageCommand createMessageCommand) throws PersistenceException;
    public R handleCreateAccountTypeCommand(PersistentCreateAccountTypeCommand createAccountTypeCommand) throws PersistenceException;
    public R handleObservationManager(PersistentObservationManager observationManager) throws PersistenceException;
    public R handleMEnumValue(PersistentMEnumValue mEnumValue) throws PersistenceException;
    public R handleDivCommand(PersistentDivCommand divCommand) throws PersistenceException;
    public R handleQuantityManager(PersistentQuantityManager quantityManager) throws PersistenceException;
    public R handleNameSchemeManager(PersistentNameSchemeManager nameSchemeManager) throws PersistenceException;
    public R handleCreateStaticOpCommand(PersistentCreateStaticOpCommand createStaticOpCommand) throws PersistenceException;
    public R handleAssociationManager(PersistentAssociationManager associationManager) throws PersistenceException;
    public R handleCreateAccountCommand(PersistentCreateAccountCommand createAccountCommand) throws PersistenceException;
    public R handleCreateAtomicSubTypeCommand(PersistentCreateAtomicSubTypeCommand createAtomicSubTypeCommand) throws PersistenceException;
    public R handleCreateLinkCommand(PersistentCreateLinkCommand createLinkCommand) throws PersistenceException;
    public R handleCreateVoidOperationCommand(PersistentCreateVoidOperationCommand createVoidOperationCommand) throws PersistenceException;
    public R handleCreateObsTypeCommand(PersistentCreateObsTypeCommand createObsTypeCommand) throws PersistenceException;
    public R handleSetDefaultUnitCommand(PersistentSetDefaultUnitCommand setDefaultUnitCommand) throws PersistenceException;
    public R handleChangeAbstractCommand(PersistentChangeAbstractCommand changeAbstractCommand) throws PersistenceException;
    public R handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    public R handleAvgStrategy(PersistentAvgStrategy avgStrategy) throws PersistenceException;
    public R handleDeleteObsTypeCommand(PersistentDeleteObsTypeCommand deleteObsTypeCommand) throws PersistenceException;
    public R handleRemoveAssociationCommand(PersistentRemoveAssociationCommand removeAssociationCommand) throws PersistenceException;
    public R handleHierarchy(PersistentHierarchy hierarchy) throws PersistenceException;
    public R handleAddFpCommand(PersistentAddFpCommand addFpCommand) throws PersistenceException;
    public R handleCreateStaticMessageCommand(PersistentCreateStaticMessageCommand createStaticMessageCommand) throws PersistenceException;
    public R handleCreateEnumValueCommand(PersistentCreateEnumValueCommand createEnumValueCommand) throws PersistenceException;
    public R handleTypeManager(PersistentTypeManager typeManager) throws PersistenceException;
    public R handleSubCommand(PersistentSubCommand subCommand) throws PersistenceException;
    public R handleMessageManager(PersistentMessageManager messageManager) throws PersistenceException;
    public R handleSumStrategy(PersistentSumStrategy sumStrategy) throws PersistenceException;
    public R handleUnitTypeManager(PersistentUnitTypeManager unitTypeManager) throws PersistenceException;
    public R handleCreateVoidMessageCommand(PersistentCreateVoidMessageCommand createVoidMessageCommand) throws PersistenceException;
    public R handleEnumerationManager(PersistentEnumerationManager enumerationManager) throws PersistenceException;
    public R handleAddAssociationCommand(PersistentAddAssociationCommand addAssociationCommand) throws PersistenceException;
    public R handleReplaceTypeCommand(PersistentReplaceTypeCommand replaceTypeCommand) throws PersistenceException;
    public R handleFetchScalarTypeCommand(PersistentFetchScalarTypeCommand fetchScalarTypeCommand) throws PersistenceException;
    public R handleCreateConstCommand(PersistentCreateConstCommand createConstCommand) throws PersistenceException;
    public R handleCreateOperationCommand(PersistentCreateOperationCommand createOperationCommand) throws PersistenceException;
    public R handleFractionManager(PersistentFractionManager fractionManager) throws PersistenceException;
    public R handleRemoveUnitCommand(PersistentRemoveUnitCommand removeUnitCommand) throws PersistenceException;
    public R handleConversion(PersistentConversion conversion) throws PersistenceException;
    public R handleReference(PersistentReference reference) throws PersistenceException;
    public R handleCreateObservationCommand(PersistentCreateObservationCommand createObservationCommand) throws PersistenceException;
    public R handleReferenceType(PersistentReferenceType referenceType) throws PersistenceException;
    public R handleMaxStrategy(PersistentMaxStrategy maxStrategy) throws PersistenceException;
    public R handleDeleteObservationCommand(PersistentDeleteObservationCommand deleteObservationCommand) throws PersistenceException;
    public R handleMeasurementTypeManager(PersistentMeasurementTypeManager measurementTypeManager) throws PersistenceException;
    public R handleAddMultipleFpCommand(PersistentAddMultipleFpCommand addMultipleFpCommand) throws PersistenceException;
    public R handleLinkManager(PersistentLinkManager linkManager) throws PersistenceException;
    public R handleCreateAssociationCommand(PersistentCreateAssociationCommand createAssociationCommand) throws PersistenceException;
    public R handleCreateAtomicRootTypeCommand(PersistentCreateAtomicRootTypeCommand createAtomicRootTypeCommand) throws PersistenceException;
    public R handleAddCommand(PersistentAddCommand addCommand) throws PersistenceException;
    public R handleConvertCommand(PersistentConvertCommand convertCommand) throws PersistenceException;
    public R handleDeleteEnumValueCommand(PersistentDeleteEnumValueCommand deleteEnumValueCommand) throws PersistenceException;
    public R handleAddReferenceTypeCommand(PersistentAddReferenceTypeCommand addReferenceTypeCommand) throws PersistenceException;
    public R handleActualParameter(PersistentActualParameter actualParameter) throws PersistenceException;
    public R handleAddSubAccountCommand(PersistentAddSubAccountCommand addSubAccountCommand) throws PersistenceException;
    public R handleName(PersistentName name) throws PersistenceException;
    public R handleAddFractionCommand(PersistentAddFractionCommand addFractionCommand) throws PersistenceException;
    public R handleRemoveFpFromOpCommand(PersistentRemoveFpFromOpCommand removeFpFromOpCommand) throws PersistenceException;
    public R handleFractionWrapper(PersistentFractionWrapper fractionWrapper) throws PersistenceException;
    public R handleRemoveMessageCommand(PersistentRemoveMessageCommand removeMessageCommand) throws PersistenceException;
    public R handleFunctionManager(PersistentFunctionManager functionManager) throws PersistenceException;
    public R handleObjectManager(PersistentObjectManager objectManager) throws PersistenceException;
    public R handleCreateFpCommand(PersistentCreateFpCommand createFpCommand) throws PersistenceException;
    
}
