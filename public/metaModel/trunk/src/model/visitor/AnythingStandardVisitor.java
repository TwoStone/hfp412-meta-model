
package model.visitor;

import persistence.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleCreateMObjectCommand(PersistentCreateMObjectCommand createMObjectCommand) throws PersistenceException{
        this.standardHandling(createMObjectCommand);
    }
    public void handleAddTypeCommand(PersistentAddTypeCommand addTypeCommand) throws PersistenceException{
        this.standardHandling(addTypeCommand);
    }
    public void handleCreateUnitTypeCommand(PersistentCreateUnitTypeCommand createUnitTypeCommand) throws PersistenceException{
        this.standardHandling(createUnitTypeCommand);
    }
    public void handleCreateUnitCommand(PersistentCreateUnitCommand createUnitCommand) throws PersistenceException{
        this.standardHandling(createUnitCommand);
    }
    public void handleCreateAspectCommand(PersistentCreateAspectCommand createAspectCommand) throws PersistenceException{
        this.standardHandling(createAspectCommand);
    }
    public void handleNameSchemeInstance(PersistentNameSchemeInstance nameSchemeInstance) throws PersistenceException{
        this.standardHandling(nameSchemeInstance);
    }
    public void handleRemoveTypeCommand(PersistentRemoveTypeCommand removeTypeCommand) throws PersistenceException{
        this.standardHandling(removeTypeCommand);
    }
    public void handleCompoundQuantity(PersistentCompoundQuantity compoundQuantity) throws PersistenceException{
        this.standardHandling(compoundQuantity);
    }
    public void handleAddDefaultUnitCommand(PersistentAddDefaultUnitCommand addDefaultUnitCommand) throws PersistenceException{
        this.standardHandling(addDefaultUnitCommand);
    }
    public void handleRemoveAssoFrmHierCommand(PersistentRemoveAssoFrmHierCommand removeAssoFrmHierCommand) throws PersistenceException{
        this.standardHandling(removeAssoFrmHierCommand);
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
    public void handleAssignNameCommand(PersistentAssignNameCommand assignNameCommand) throws PersistenceException{
        this.standardHandling(assignNameCommand);
    }
    public void handleCompUnitType(PersistentCompUnitType compUnitType) throws PersistenceException{
        this.standardHandling(compUnitType);
    }
    public void handleMeasurement(PersistentMeasurement measurement) throws PersistenceException{
        this.standardHandling(measurement);
    }
    public void handleMProductType(PersistentMProductType mProductType) throws PersistenceException{
        this.standardHandling(mProductType);
    }
    public void handleAssociation(PersistentAssociation association) throws PersistenceException{
        this.standardHandling(association);
    }
    public void handleCreateInstanceCommand(PersistentCreateInstanceCommand createInstanceCommand) throws PersistenceException{
        this.standardHandling(createInstanceCommand);
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
    public void handleMEmptyProductType(PersistentMEmptyProductType mEmptyProductType) throws PersistenceException{
        this.standardHandling(mEmptyProductType);
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
    public void handleInstanceObject(PersistentInstanceObject instanceObject) throws PersistenceException{
        this.standardHandling(instanceObject);
    }
    public void handleRemoveFpCommand(PersistentRemoveFpCommand removeFpCommand) throws PersistenceException{
        this.standardHandling(removeFpCommand);
    }
    public void handleNameInstance(PersistentNameInstance nameInstance) throws PersistenceException{
        this.standardHandling(nameInstance);
    }
    public void handleMessage(PersistentMessage message) throws PersistenceException{
        this.standardHandling(message);
    }
    public void handleNameSchemeInstaceManager(PersistentNameSchemeInstaceManager nameSchemeInstaceManager) throws PersistenceException{
        this.standardHandling(nameSchemeInstaceManager);
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
    public void handleLink(PersistentLink link) throws PersistenceException{
        this.standardHandling(link);
    }
    public void handleMAspect(PersistentMAspect mAspect) throws PersistenceException{
        this.standardHandling(mAspect);
    }
    public void handleCreateNameSchemeCommand(PersistentCreateNameSchemeCommand createNameSchemeCommand) throws PersistenceException{
        this.standardHandling(createNameSchemeCommand);
    }
    public void handleAccountManager(PersistentAccountManager accountManager) throws PersistenceException{
        this.standardHandling(accountManager);
    }
    public void handleMSumType(PersistentMSumType mSumType) throws PersistenceException{
        this.standardHandling(mSumType);
    }
    public void handleCreateMessageCommand(PersistentCreateMessageCommand createMessageCommand) throws PersistenceException{
        this.standardHandling(createMessageCommand);
    }
    public void handleCompUnit(PersistentCompUnit compUnit) throws PersistenceException{
        this.standardHandling(compUnit);
    }
    public void handleCreateAccountTypeCommand(PersistentCreateAccountTypeCommand createAccountTypeCommand) throws PersistenceException{
        this.standardHandling(createAccountTypeCommand);
    }
    public void handleOperation(PersistentOperation operation) throws PersistenceException{
        this.standardHandling(operation);
    }
    public void handleConversionManager(PersistentConversionManager conversionManager) throws PersistenceException{
        this.standardHandling(conversionManager);
    }
    public void handleQuantityManager(PersistentQuantityManager quantityManager) throws PersistenceException{
        this.standardHandling(quantityManager);
    }
    public void handleNameSchemeManager(PersistentNameSchemeManager nameSchemeManager) throws PersistenceException{
        this.standardHandling(nameSchemeManager);
    }
    public void handleCreateProductTypeCommand(PersistentCreateProductTypeCommand createProductTypeCommand) throws PersistenceException{
        this.standardHandling(createProductTypeCommand);
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
    public void handleCreateConversionCommand(PersistentCreateConversionCommand createConversionCommand) throws PersistenceException{
        this.standardHandling(createConversionCommand);
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
    public void handleCreateCompUnitCommand(PersistentCreateCompUnitCommand createCompUnitCommand) throws PersistenceException{
        this.standardHandling(createCompUnitCommand);
    }
    public void handleCreateCompUnitTypeCommand(PersistentCreateCompUnitTypeCommand createCompUnitTypeCommand) throws PersistenceException{
        this.standardHandling(createCompUnitTypeCommand);
    }
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException{
        this.standardHandling(commonDate);
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
    public void handleCreateConstCommand(PersistentCreateConstCommand createConstCommand) throws PersistenceException{
        this.standardHandling(createConstCommand);
    }
    public void handleAssignNameSchemeCommand(PersistentAssignNameSchemeCommand assignNameSchemeCommand) throws PersistenceException{
        this.standardHandling(assignNameSchemeCommand);
    }
    public void handleCreateOperationCommand(PersistentCreateOperationCommand createOperationCommand) throws PersistenceException{
        this.standardHandling(createOperationCommand);
    }
    public void handleFractionManager(PersistentFractionManager fractionManager) throws PersistenceException{
        this.standardHandling(fractionManager);
    }
    public void handleConversion(PersistentConversion conversion) throws PersistenceException{
        this.standardHandling(conversion);
    }
    public void handleReference(PersistentReference reference) throws PersistenceException{
        this.standardHandling(reference);
    }
    public void handleFinishModelingCommand(PersistentFinishModelingCommand finishModelingCommand) throws PersistenceException{
        this.standardHandling(finishModelingCommand);
    }
    public void handleReferenceType(PersistentReferenceType referenceType) throws PersistenceException{
        this.standardHandling(referenceType);
    }
    public void handleAccount(PersistentAccount account) throws PersistenceException{
        this.standardHandling(account);
    }
    public void handleUnitType(PersistentUnitType unitType) throws PersistenceException{
        this.standardHandling(unitType);
    }
    public void handleMFalse(PersistentMFalse mFalse) throws PersistenceException{
        this.standardHandling(mFalse);
    }
    public void handleMeasurementTypeManager(PersistentMeasurementTypeManager measurementTypeManager) throws PersistenceException{
        this.standardHandling(measurementTypeManager);
    }
    public void handleAddMultipleFpCommand(PersistentAddMultipleFpCommand addMultipleFpCommand) throws PersistenceException{
        this.standardHandling(addMultipleFpCommand);
    }
    public void handleMEmptySumType(PersistentMEmptySumType mEmptySumType) throws PersistenceException{
        this.standardHandling(mEmptySumType);
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
    public void handleName(PersistentName name) throws PersistenceException{
        this.standardHandling(name);
    }
    public void handleCreateSumTypeCommand(PersistentCreateSumTypeCommand createSumTypeCommand) throws PersistenceException{
        this.standardHandling(createSumTypeCommand);
    }
    public void handleRemoveFpFromOpCommand(PersistentRemoveFpFromOpCommand removeFpFromOpCommand) throws PersistenceException{
        this.standardHandling(removeFpFromOpCommand);
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
