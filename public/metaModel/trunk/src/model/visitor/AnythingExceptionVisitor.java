
package model.visitor;
import model.UserException;
import persistence.*;

public interface AnythingExceptionVisitor<E extends UserException> extends AbstractObjectExceptionVisitor<E>,AbsOperationExceptionVisitor<E>,QuantifObjectExceptionVisitor<E>,MQuantiObjectTypeExceptionVisitor<E>,MModelItemExceptionVisitor<E>,MBooleanExceptionVisitor<E>,BasicCalculationExceptionVisitor<E>,AbsUnitTypeExceptionVisitor<E>,AbsQuantityExceptionVisitor<E>,CommonDateExceptionVisitor<E>,MTypeExceptionVisitor<E>,AbsUnitExceptionVisitor<E>,MessageOrLinkExceptionVisitor<E>{
    
    public void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException, E;
    public void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException, E;
    public void handleConvertToDefaultCommand(PersistentConvertToDefaultCommand convertToDefaultCommand) throws PersistenceException, E;
    public void handleAddTypeCommand(PersistentAddTypeCommand addTypeCommand) throws PersistenceException, E;
    public void handleCreateMObjectCommand(PersistentCreateMObjectCommand createMObjectCommand) throws PersistenceException, E;
    public void handleAssignTypeCommand(PersistentAssignTypeCommand assignTypeCommand) throws PersistenceException, E;
    public void handleMinStrategy(PersistentMinStrategy minStrategy) throws PersistenceException, E;
    public void handleCreateUnitTypeCommand(PersistentCreateUnitTypeCommand createUnitTypeCommand) throws PersistenceException, E;
    public void handleRemoveUnitTypeCommand(PersistentRemoveUnitTypeCommand removeUnitTypeCommand) throws PersistenceException, E;
    public void handleCreateAspectCommand(PersistentCreateAspectCommand createAspectCommand) throws PersistenceException, E;
    public void handleCreateUnitCommand(PersistentCreateUnitCommand createUnitCommand) throws PersistenceException, E;
    public void handleNameSchemeInstance(PersistentNameSchemeInstance nameSchemeInstance) throws PersistenceException, E;
    public void handleCreateTypeDisjunctionCommand(PersistentCreateTypeDisjunctionCommand createTypeDisjunctionCommand) throws PersistenceException, E;
    public void handleRemoveTypeCommand(PersistentRemoveTypeCommand removeTypeCommand) throws PersistenceException, E;
    public void handleRemoveAssoFrmHierCommand(PersistentRemoveAssoFrmHierCommand removeAssoFrmHierCommand) throws PersistenceException, E;
    public void handleSetConversionCommand(PersistentSetConversionCommand setConversionCommand) throws PersistenceException, E;
    public void handleServer(PersistentServer server) throws PersistenceException, E;
    public void handleNameScheme(PersistentNameScheme nameScheme) throws PersistenceException, E;
    public void handleCreateTypeConjunctionCommand(PersistentCreateTypeConjunctionCommand createTypeConjunctionCommand) throws PersistenceException, E;
    public void handleAssignNameCommand(PersistentAssignNameCommand assignNameCommand) throws PersistenceException, E;
    public void handleAggregateCommand(PersistentAggregateCommand aggregateCommand) throws PersistenceException, E;
    public void handleAddSubAccountTypeCommand(PersistentAddSubAccountTypeCommand addSubAccountTypeCommand) throws PersistenceException, E;
    public void handleRemoveLinkCommand(PersistentRemoveLinkCommand removeLinkCommand) throws PersistenceException, E;
    public void handleFormalParameter(PersistentFormalParameter formalParameter) throws PersistenceException, E;
    public void handleCreateHierarchyCommand(PersistentCreateHierarchyCommand createHierarchyCommand) throws PersistenceException, E;
    public void handleOperationManager(PersistentOperationManager operationManager) throws PersistenceException, E;
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException, E;
    public void handleMulCommand(PersistentMulCommand mulCommand) throws PersistenceException, E;
    public void handleCreateMeasurementTypeCommand(PersistentCreateMeasurementTypeCommand createMeasurementTypeCommand) throws PersistenceException, E;
    public void handleAccountTypeManager(PersistentAccountTypeManager accountTypeManager) throws PersistenceException, E;
    public void handleCreateQuantityCommand(PersistentCreateQuantityCommand createQuantityCommand) throws PersistenceException, E;
    public void handleRemoveFpCommand(PersistentRemoveFpCommand removeFpCommand) throws PersistenceException, E;
    public void handleGetExistingCUTCommand(PersistentGetExistingCUTCommand getExistingCUTCommand) throws PersistenceException, E;
    public void handleFetchScalarCommand(PersistentFetchScalarCommand fetchScalarCommand) throws PersistenceException, E;
    public void handleNameInstance(PersistentNameInstance nameInstance) throws PersistenceException, E;
    public void handleFunction(PersistentFunction function) throws PersistenceException, E;
    public void handleAspectManager(PersistentAspectManager aspectManager) throws PersistenceException, E;
    public void handleRemoveOperationCommand(PersistentRemoveOperationCommand removeOperationCommand) throws PersistenceException, E;
    public void handleCreateConstantCommand(PersistentCreateConstantCommand createConstantCommand) throws PersistenceException, E;
    public void handleAddReferenceCommand(PersistentAddReferenceCommand addReferenceCommand) throws PersistenceException, E;
    public void handleMAspect(PersistentMAspect mAspect) throws PersistenceException, E;
    public void handleAccountManager(PersistentAccountManager accountManager) throws PersistenceException, E;
    public void handleCreateNameSchemeCommand(PersistentCreateNameSchemeCommand createNameSchemeCommand) throws PersistenceException, E;
    public void handleAddEntryCommand(PersistentAddEntryCommand addEntryCommand) throws PersistenceException, E;
    public void handleCreateMessageCommand(PersistentCreateMessageCommand createMessageCommand) throws PersistenceException, E;
    public void handleCreateAccountTypeCommand(PersistentCreateAccountTypeCommand createAccountTypeCommand) throws PersistenceException, E;
    public void handleDivCommand(PersistentDivCommand divCommand) throws PersistenceException, E;
    public void handleQuantityManager(PersistentQuantityManager quantityManager) throws PersistenceException, E;
    public void handleNameSchemeManager(PersistentNameSchemeManager nameSchemeManager) throws PersistenceException, E;
    public void handleCreateStaticOpCommand(PersistentCreateStaticOpCommand createStaticOpCommand) throws PersistenceException, E;
    public void handleAssociationManager(PersistentAssociationManager associationManager) throws PersistenceException, E;
    public void handleCreateAccountCommand(PersistentCreateAccountCommand createAccountCommand) throws PersistenceException, E;
    public void handleCreateAtomicSubTypeCommand(PersistentCreateAtomicSubTypeCommand createAtomicSubTypeCommand) throws PersistenceException, E;
    public void handleCreateLinkCommand(PersistentCreateLinkCommand createLinkCommand) throws PersistenceException, E;
    public void handleCreateVoidOperationCommand(PersistentCreateVoidOperationCommand createVoidOperationCommand) throws PersistenceException, E;
    public void handleSetDefaultUnitCommand(PersistentSetDefaultUnitCommand setDefaultUnitCommand) throws PersistenceException, E;
    public void handleChangeAbstractCommand(PersistentChangeAbstractCommand changeAbstractCommand) throws PersistenceException, E;
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException, E;
    public void handleAvgStrategy(PersistentAvgStrategy avgStrategy) throws PersistenceException, E;
    public void handleRemoveAssociationCommand(PersistentRemoveAssociationCommand removeAssociationCommand) throws PersistenceException, E;
    public void handleHierarchy(PersistentHierarchy hierarchy) throws PersistenceException, E;
    public void handleAddFpCommand(PersistentAddFpCommand addFpCommand) throws PersistenceException, E;
    public void handleCreateStaticMessageCommand(PersistentCreateStaticMessageCommand createStaticMessageCommand) throws PersistenceException, E;
    public void handleTypeManager(PersistentTypeManager typeManager) throws PersistenceException, E;
    public void handleSubCommand(PersistentSubCommand subCommand) throws PersistenceException, E;
    public void handleMessageManager(PersistentMessageManager messageManager) throws PersistenceException, E;
    public void handleSumStrategy(PersistentSumStrategy sumStrategy) throws PersistenceException, E;
    public void handleUnitTypeManager(PersistentUnitTypeManager unitTypeManager) throws PersistenceException, E;
    public void handleCreateVoidMessageCommand(PersistentCreateVoidMessageCommand createVoidMessageCommand) throws PersistenceException, E;
    public void handleAddAssociationCommand(PersistentAddAssociationCommand addAssociationCommand) throws PersistenceException, E;
    public void handleReplaceTypeCommand(PersistentReplaceTypeCommand replaceTypeCommand) throws PersistenceException, E;
    public void handleFetchScalarTypeCommand(PersistentFetchScalarTypeCommand fetchScalarTypeCommand) throws PersistenceException, E;
    public void handleCreateConstCommand(PersistentCreateConstCommand createConstCommand) throws PersistenceException, E;
    public void handleCreateOperationCommand(PersistentCreateOperationCommand createOperationCommand) throws PersistenceException, E;
    public void handleFractionManager(PersistentFractionManager fractionManager) throws PersistenceException, E;
    public void handleRemoveUnitCommand(PersistentRemoveUnitCommand removeUnitCommand) throws PersistenceException, E;
    public void handleConversion(PersistentConversion conversion) throws PersistenceException, E;
    public void handleReference(PersistentReference reference) throws PersistenceException, E;
    public void handleReferenceType(PersistentReferenceType referenceType) throws PersistenceException, E;
    public void handleMaxStrategy(PersistentMaxStrategy maxStrategy) throws PersistenceException, E;
    public void handleMeasurementTypeManager(PersistentMeasurementTypeManager measurementTypeManager) throws PersistenceException, E;
    public void handleAddMultipleFpCommand(PersistentAddMultipleFpCommand addMultipleFpCommand) throws PersistenceException, E;
    public void handleLinkManager(PersistentLinkManager linkManager) throws PersistenceException, E;
    public void handleCreateAssociationCommand(PersistentCreateAssociationCommand createAssociationCommand) throws PersistenceException, E;
    public void handleCreateAtomicRootTypeCommand(PersistentCreateAtomicRootTypeCommand createAtomicRootTypeCommand) throws PersistenceException, E;
    public void handleAddCommand(PersistentAddCommand addCommand) throws PersistenceException, E;
    public void handleConvertCommand(PersistentConvertCommand convertCommand) throws PersistenceException, E;
    public void handleAddReferenceTypeCommand(PersistentAddReferenceTypeCommand addReferenceTypeCommand) throws PersistenceException, E;
    public void handleActualParameter(PersistentActualParameter actualParameter) throws PersistenceException, E;
    public void handleAddSubAccountCommand(PersistentAddSubAccountCommand addSubAccountCommand) throws PersistenceException, E;
    public void handleName(PersistentName name) throws PersistenceException, E;
    public void handleAddFractionCommand(PersistentAddFractionCommand addFractionCommand) throws PersistenceException, E;
    public void handleRemoveFpFromOpCommand(PersistentRemoveFpFromOpCommand removeFpFromOpCommand) throws PersistenceException, E;
    public void handleFractionWrapper(PersistentFractionWrapper fractionWrapper) throws PersistenceException, E;
    public void handleRemoveMessageCommand(PersistentRemoveMessageCommand removeMessageCommand) throws PersistenceException, E;
    public void handleFunctionManager(PersistentFunctionManager functionManager) throws PersistenceException, E;
    public void handleObjectManager(PersistentObjectManager objectManager) throws PersistenceException, E;
    public void handleCreateFpCommand(PersistentCreateFpCommand createFpCommand) throws PersistenceException, E;
    
}
