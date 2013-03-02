
package model.visitor;

import persistence.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleConvertToDefaultCommand(PersistentConvertToDefaultCommand convertToDefaultCommand) throws PersistenceException{
        this.standardHandling(convertToDefaultCommand);
    }
    public void handleAssignTypeCommand(PersistentAssignTypeCommand assignTypeCommand) throws PersistenceException{
        this.standardHandling(assignTypeCommand);
    }
    public void handleCreateMObjectCommand(PersistentCreateMObjectCommand createMObjectCommand) throws PersistenceException{
        this.standardHandling(createMObjectCommand);
    }
    public void handleAddTypeCommand(PersistentAddTypeCommand addTypeCommand) throws PersistenceException{
        this.standardHandling(addTypeCommand);
    }
    public void handleMinStrategy(PersistentMinStrategy minStrategy) throws PersistenceException{
        this.standardHandling(minStrategy);
    }
    public void handleCreateUnitTypeCommand(PersistentCreateUnitTypeCommand createUnitTypeCommand) throws PersistenceException{
        this.standardHandling(createUnitTypeCommand);
    }
    public void handleRemoveUnitTypeCommand(PersistentRemoveUnitTypeCommand removeUnitTypeCommand) throws PersistenceException{
        this.standardHandling(removeUnitTypeCommand);
    }
    public void handleCreateAspectCommand(PersistentCreateAspectCommand createAspectCommand) throws PersistenceException{
        this.standardHandling(createAspectCommand);
    }
    public void handleCreateUnitCommand(PersistentCreateUnitCommand createUnitCommand) throws PersistenceException{
        this.standardHandling(createUnitCommand);
    }
    public void handleNameSchemeInstance(PersistentNameSchemeInstance nameSchemeInstance) throws PersistenceException{
        this.standardHandling(nameSchemeInstance);
    }
    public void handleCreateTypeDisjunctionCommand(PersistentCreateTypeDisjunctionCommand createTypeDisjunctionCommand) throws PersistenceException{
        this.standardHandling(createTypeDisjunctionCommand);
    }
    public void handleRemoveTypeCommand(PersistentRemoveTypeCommand removeTypeCommand) throws PersistenceException{
        this.standardHandling(removeTypeCommand);
    }
    public void handleCompoundQuantity(PersistentCompoundQuantity compoundQuantity) throws PersistenceException{
        this.standardHandling(compoundQuantity);
    }
    public void handleRemoveAssoFrmHierCommand(PersistentRemoveAssoFrmHierCommand removeAssoFrmHierCommand) throws PersistenceException{
        this.standardHandling(removeAssoFrmHierCommand);
    }
    public void handleSetConversionCommand(PersistentSetConversionCommand setConversionCommand) throws PersistenceException{
        this.standardHandling(setConversionCommand);
    }
    public void handleServer(PersistentServer server) throws PersistenceException{
        this.standardHandling(server);
    }
    public void handleNameScheme(PersistentNameScheme nameScheme) throws PersistenceException{
        this.standardHandling(nameScheme);
    }
    public void handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException{
        this.standardHandling(mAtomicType);
    }
    public void handleCreateTypeConjunctionCommand(PersistentCreateTypeConjunctionCommand createTypeConjunctionCommand) throws PersistenceException{
        this.standardHandling(createTypeConjunctionCommand);
    }
    public void handleMEmptyTypeDisjunction(PersistentMEmptyTypeDisjunction mEmptyTypeDisjunction) throws PersistenceException{
        this.standardHandling(mEmptyTypeDisjunction);
    }
    public void handleAssignNameCommand(PersistentAssignNameCommand assignNameCommand) throws PersistenceException{
        this.standardHandling(assignNameCommand);
    }
    public void handleAggregateCommand(PersistentAggregateCommand aggregateCommand) throws PersistenceException{
        this.standardHandling(aggregateCommand);
    }
    public void handleCompUnitType(PersistentCompUnitType compUnitType) throws PersistenceException{
        this.standardHandling(compUnitType);
    }
    public void handleMeasurement(PersistentMeasurement measurement) throws PersistenceException{
        this.standardHandling(measurement);
    }
    public void handleAddSubAccountTypeCommand(PersistentAddSubAccountTypeCommand addSubAccountTypeCommand) throws PersistenceException{
        this.standardHandling(addSubAccountTypeCommand);
    }
    public void handleAssociation(PersistentAssociation association) throws PersistenceException{
        this.standardHandling(association);
    }
    public void handleRemoveLinkCommand(PersistentRemoveLinkCommand removeLinkCommand) throws PersistenceException{
        this.standardHandling(removeLinkCommand);
    }
    public void handleFormalParameter(PersistentFormalParameter formalParameter) throws PersistenceException{
        this.standardHandling(formalParameter);
    }
    public void handleCreateHierarchyCommand(PersistentCreateHierarchyCommand createHierarchyCommand) throws PersistenceException{
        this.standardHandling(createHierarchyCommand);
    }
    public void handleOperationManager(PersistentOperationManager operationManager) throws PersistenceException{
        this.standardHandling(operationManager);
    }
    public void handleMMixedConjunction(PersistentMMixedConjunction mMixedConjunction) throws PersistenceException{
        this.standardHandling(mMixedConjunction);
    }
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException{
        this.standardHandling(errorDisplay);
    }
    public void handleUnit(PersistentUnit unit) throws PersistenceException{
        this.standardHandling(unit);
    }
    public void handleCreateMeasurementTypeCommand(PersistentCreateMeasurementTypeCommand createMeasurementTypeCommand) throws PersistenceException{
        this.standardHandling(createMeasurementTypeCommand);
    }
    public void handleMMeasurementType(PersistentMMeasurementType mMeasurementType) throws PersistenceException{
        this.standardHandling(mMeasurementType);
    }
    public void handleAccountTypeManager(PersistentAccountTypeManager accountTypeManager) throws PersistenceException{
        this.standardHandling(accountTypeManager);
    }
    public void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException{
        this.standardHandling(commandCoordinator);
    }
    public void handleMObject(PersistentMObject mObject) throws PersistenceException{
        this.standardHandling(mObject);
    }
    public void handleCreateQuantityCommand(PersistentCreateQuantityCommand createQuantityCommand) throws PersistenceException{
        this.standardHandling(createQuantityCommand);
    }
    public void handleRemoveFpCommand(PersistentRemoveFpCommand removeFpCommand) throws PersistenceException{
        this.standardHandling(removeFpCommand);
    }
    public void handleFetchScalarCommand(PersistentFetchScalarCommand fetchScalarCommand) throws PersistenceException{
        this.standardHandling(fetchScalarCommand);
    }
    public void handleMEmptyTypeConjunction(PersistentMEmptyTypeConjunction mEmptyTypeConjunction) throws PersistenceException{
        this.standardHandling(mEmptyTypeConjunction);
    }
    public void handleNameInstance(PersistentNameInstance nameInstance) throws PersistenceException{
        this.standardHandling(nameInstance);
    }
    public void handleMessage(PersistentMessage message) throws PersistenceException{
        this.standardHandling(message);
    }
    public void handleFunction(PersistentFunction function) throws PersistenceException{
        this.standardHandling(function);
    }
    public void handleAspectManager(PersistentAspectManager aspectManager) throws PersistenceException{
        this.standardHandling(aspectManager);
    }
    public void handleRemoveOperationCommand(PersistentRemoveOperationCommand removeOperationCommand) throws PersistenceException{
        this.standardHandling(removeOperationCommand);
    }
    public void handleCreateConstantCommand(PersistentCreateConstantCommand createConstantCommand) throws PersistenceException{
        this.standardHandling(createConstantCommand);
    }
    public void handleAddReferenceCommand(PersistentAddReferenceCommand addReferenceCommand) throws PersistenceException{
        this.standardHandling(addReferenceCommand);
    }
    public void handleLink(PersistentLink link) throws PersistenceException{
        this.standardHandling(link);
    }
    public void handleMAspect(PersistentMAspect mAspect) throws PersistenceException{
        this.standardHandling(mAspect);
    }
    public void handleAccountManager(PersistentAccountManager accountManager) throws PersistenceException{
        this.standardHandling(accountManager);
    }
    public void handleCreateNameSchemeCommand(PersistentCreateNameSchemeCommand createNameSchemeCommand) throws PersistenceException{
        this.standardHandling(createNameSchemeCommand);
    }
    public void handleAddEntryCommand(PersistentAddEntryCommand addEntryCommand) throws PersistenceException{
        this.standardHandling(addEntryCommand);
    }
    public void handleCompUnit(PersistentCompUnit compUnit) throws PersistenceException{
        this.standardHandling(compUnit);
    }
    public void handleCreateMessageCommand(PersistentCreateMessageCommand createMessageCommand) throws PersistenceException{
        this.standardHandling(createMessageCommand);
    }
    public void handleCreateAccountTypeCommand(PersistentCreateAccountTypeCommand createAccountTypeCommand) throws PersistenceException{
        this.standardHandling(createAccountTypeCommand);
    }
    public void handleOperation(PersistentOperation operation) throws PersistenceException{
        this.standardHandling(operation);
    }
    public void handleCONCMModelItem(PersistentCONCMModelItem cONCMModelItem) throws PersistenceException{
        this.standardHandling(cONCMModelItem);
    }
    public void handleQuantityManager(PersistentQuantityManager quantityManager) throws PersistenceException{
        this.standardHandling(quantityManager);
    }
    public void handleNameSchemeManager(PersistentNameSchemeManager nameSchemeManager) throws PersistenceException{
        this.standardHandling(nameSchemeManager);
    }
    public void handleCreateStaticOpCommand(PersistentCreateStaticOpCommand createStaticOpCommand) throws PersistenceException{
        this.standardHandling(createStaticOpCommand);
    }
    public void handleAssociationManager(PersistentAssociationManager associationManager) throws PersistenceException{
        this.standardHandling(associationManager);
    }
    public void handleCreateAccountCommand(PersistentCreateAccountCommand createAccountCommand) throws PersistenceException{
        this.standardHandling(createAccountCommand);
    }
    public void handleCreateAtomicSubTypeCommand(PersistentCreateAtomicSubTypeCommand createAtomicSubTypeCommand) throws PersistenceException{
        this.standardHandling(createAtomicSubTypeCommand);
    }
    public void handleCreateLinkCommand(PersistentCreateLinkCommand createLinkCommand) throws PersistenceException{
        this.standardHandling(createLinkCommand);
    }
    public void handleCreateVoidOperationCommand(PersistentCreateVoidOperationCommand createVoidOperationCommand) throws PersistenceException{
        this.standardHandling(createVoidOperationCommand);
    }
    public void handleSetDefaultUnitCommand(PersistentSetDefaultUnitCommand setDefaultUnitCommand) throws PersistenceException{
        this.standardHandling(setDefaultUnitCommand);
    }
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException{
        this.standardHandling(commonDate);
    }
    public void handleChangeAbstractCommand(PersistentChangeAbstractCommand changeAbstractCommand) throws PersistenceException{
        this.standardHandling(changeAbstractCommand);
    }
    public void handleAvgStrategy(PersistentAvgStrategy avgStrategy) throws PersistenceException{
        this.standardHandling(avgStrategy);
    }
    public void handleRemoveAssociationCommand(PersistentRemoveAssociationCommand removeAssociationCommand) throws PersistenceException{
        this.standardHandling(removeAssociationCommand);
    }
    public void handleHierarchy(PersistentHierarchy hierarchy) throws PersistenceException{
        this.standardHandling(hierarchy);
    }
    public void handleMAccountType(PersistentMAccountType mAccountType) throws PersistenceException{
        this.standardHandling(mAccountType);
    }
    public void handleAddFpCommand(PersistentAddFpCommand addFpCommand) throws PersistenceException{
        this.standardHandling(addFpCommand);
    }
    public void handleCreateStaticMessageCommand(PersistentCreateStaticMessageCommand createStaticMessageCommand) throws PersistenceException{
        this.standardHandling(createStaticMessageCommand);
    }
    public void handleTypeManager(PersistentTypeManager typeManager) throws PersistenceException{
        this.standardHandling(typeManager);
    }
    public void handleMMixedTypeDisjunction(PersistentMMixedTypeDisjunction mMixedTypeDisjunction) throws PersistenceException{
        this.standardHandling(mMixedTypeDisjunction);
    }
    public void handleMNonEmptyAtomicTypeConjunction(PersistentMNonEmptyAtomicTypeConjunction mNonEmptyAtomicTypeConjunction) throws PersistenceException{
        this.standardHandling(mNonEmptyAtomicTypeConjunction);
    }
    public void handleSumStrategy(PersistentSumStrategy sumStrategy) throws PersistenceException{
        this.standardHandling(sumStrategy);
    }
    public void handleMessageManager(PersistentMessageManager messageManager) throws PersistenceException{
        this.standardHandling(messageManager);
    }
    public void handleUnitTypeManager(PersistentUnitTypeManager unitTypeManager) throws PersistenceException{
        this.standardHandling(unitTypeManager);
    }
    public void handleCreateVoidMessageCommand(PersistentCreateVoidMessageCommand createVoidMessageCommand) throws PersistenceException{
        this.standardHandling(createVoidMessageCommand);
    }
    public void handleAddAssociationCommand(PersistentAddAssociationCommand addAssociationCommand) throws PersistenceException{
        this.standardHandling(addAssociationCommand);
    }
    public void handleReplaceTypeCommand(PersistentReplaceTypeCommand replaceTypeCommand) throws PersistenceException{
        this.standardHandling(replaceTypeCommand);
    }
    public void handleMNonEmptyDisjunctiveNormalForm(PersistentMNonEmptyDisjunctiveNormalForm mNonEmptyDisjunctiveNormalForm) throws PersistenceException{
        this.standardHandling(mNonEmptyDisjunctiveNormalForm);
    }
    public void handleFetchScalarTypeCommand(PersistentFetchScalarTypeCommand fetchScalarTypeCommand) throws PersistenceException{
        this.standardHandling(fetchScalarTypeCommand);
    }
    public void handleCreateConstCommand(PersistentCreateConstCommand createConstCommand) throws PersistenceException{
        this.standardHandling(createConstCommand);
    }
    public void handleFractionManager(PersistentFractionManager fractionManager) throws PersistenceException{
        this.standardHandling(fractionManager);
    }
    public void handleCreateOperationCommand(PersistentCreateOperationCommand createOperationCommand) throws PersistenceException{
        this.standardHandling(createOperationCommand);
    }
    public void handleRemoveUnitCommand(PersistentRemoveUnitCommand removeUnitCommand) throws PersistenceException{
        this.standardHandling(removeUnitCommand);
    }
    public void handleReference(PersistentReference reference) throws PersistenceException{
        this.standardHandling(reference);
    }
    public void handleConversion(PersistentConversion conversion) throws PersistenceException{
        this.standardHandling(conversion);
    }
    public void handleMaxStrategy(PersistentMaxStrategy maxStrategy) throws PersistenceException{
        this.standardHandling(maxStrategy);
    }
    public void handleReferenceType(PersistentReferenceType referenceType) throws PersistenceException{
        this.standardHandling(referenceType);
    }
    public void handleAccount(PersistentAccount account) throws PersistenceException{
        this.standardHandling(account);
    }
    public void handleMFalse(PersistentMFalse mFalse) throws PersistenceException{
        this.standardHandling(mFalse);
    }
    public void handleUnitType(PersistentUnitType unitType) throws PersistenceException{
        this.standardHandling(unitType);
    }
    public void handleMeasurementTypeManager(PersistentMeasurementTypeManager measurementTypeManager) throws PersistenceException{
        this.standardHandling(measurementTypeManager);
    }
    public void handleAddMultipleFpCommand(PersistentAddMultipleFpCommand addMultipleFpCommand) throws PersistenceException{
        this.standardHandling(addMultipleFpCommand);
    }
    public void handleLinkManager(PersistentLinkManager linkManager) throws PersistenceException{
        this.standardHandling(linkManager);
    }
    public void handleCreateAssociationCommand(PersistentCreateAssociationCommand createAssociationCommand) throws PersistenceException{
        this.standardHandling(createAssociationCommand);
    }
    public void handleCreateAtomicRootTypeCommand(PersistentCreateAtomicRootTypeCommand createAtomicRootTypeCommand) throws PersistenceException{
        this.standardHandling(createAtomicRootTypeCommand);
    }
    public void handleMTrue(PersistentMTrue mTrue) throws PersistenceException{
        this.standardHandling(mTrue);
    }
    public void handleConvertCommand(PersistentConvertCommand convertCommand) throws PersistenceException{
        this.standardHandling(convertCommand);
    }
    public void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException{
        this.standardHandling(commandExecuter);
    }
    public void handleQuantity(PersistentQuantity quantity) throws PersistenceException{
        this.standardHandling(quantity);
    }
    public void handleAddReferenceTypeCommand(PersistentAddReferenceTypeCommand addReferenceTypeCommand) throws PersistenceException{
        this.standardHandling(addReferenceTypeCommand);
    }
    public void handleActualParameter(PersistentActualParameter actualParameter) throws PersistenceException{
        this.standardHandling(actualParameter);
    }
    public void handleAddSubAccountCommand(PersistentAddSubAccountCommand addSubAccountCommand) throws PersistenceException{
        this.standardHandling(addSubAccountCommand);
    }
    public void handleName(PersistentName name) throws PersistenceException{
        this.standardHandling(name);
    }
    public void handleMSingletonObject(PersistentMSingletonObject mSingletonObject) throws PersistenceException{
        this.standardHandling(mSingletonObject);
    }
    public void handleAddFractionCommand(PersistentAddFractionCommand addFractionCommand) throws PersistenceException{
        this.standardHandling(addFractionCommand);
    }
    public void handleRemoveFpFromOpCommand(PersistentRemoveFpFromOpCommand removeFpFromOpCommand) throws PersistenceException{
        this.standardHandling(removeFpFromOpCommand);
    }
    public void handleFractionWrapper(PersistentFractionWrapper fractionWrapper) throws PersistenceException{
        this.standardHandling(fractionWrapper);
    }
    public void handleFunctionManager(PersistentFunctionManager functionManager) throws PersistenceException{
        this.standardHandling(functionManager);
    }
    public void handleRemoveMessageCommand(PersistentRemoveMessageCommand removeMessageCommand) throws PersistenceException{
        this.standardHandling(removeMessageCommand);
    }
    public void handleObjectManager(PersistentObjectManager objectManager) throws PersistenceException{
        this.standardHandling(objectManager);
    }
    public void handleCreateFpCommand(PersistentCreateFpCommand createFpCommand) throws PersistenceException{
        this.standardHandling(createFpCommand);
    }
    protected abstract void standardHandling(Anything anything) throws PersistenceException;
}
