
package model.visitor;

import persistence.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleReferenceType(PersistentReferenceType referenceType) throws PersistenceException;
    
    public abstract void handleFormalParameter(PersistentFormalParameter formalParameter) throws PersistenceException;
    
    public abstract void handleQuantityManager(PersistentQuantityManager quantityManager) throws PersistenceException;
    
    public abstract void handleAbsUnitType(PersistentAbsUnitType absUnitType) throws PersistenceException;
    
    public void handleUnitType(PersistentUnitType unitType) throws PersistenceException{
        this.handleAbsUnitType(unitType);
    }
    public void handleCompUnitType(PersistentCompUnitType compUnitType) throws PersistenceException{
        this.handleAbsUnitType(compUnitType);
    }
    public abstract void handleOperationManager(PersistentOperationManager operationManager) throws PersistenceException;
    
    public abstract void handleNameSchemeManager(PersistentNameSchemeManager nameSchemeManager) throws PersistenceException;
    
    public abstract void handleQuantifObject(PersistentQuantifObject quantifObject) throws PersistenceException;
    
    public void handleMeasurement(PersistentMeasurement measurement) throws PersistenceException{
        this.handleQuantifObject(measurement);
    }
    public void handleAccount(PersistentAccount account) throws PersistenceException{
        this.handleQuantifObject(account);
    }
    public abstract void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    
    public abstract void handleAssociationManager(PersistentAssociationManager associationManager) throws PersistenceException;
    
    public abstract void handleMeasurementTypeManager(PersistentMeasurementTypeManager measurementTypeManager) throws PersistenceException;
    
    public abstract void handleAbsQuantity(PersistentAbsQuantity absQuantity) throws PersistenceException;
    
    public void handleQuantity(PersistentQuantity quantity) throws PersistenceException{
        this.handleAbsQuantity(quantity);
    }
    public void handleCompoundQuantity(PersistentCompoundQuantity compoundQuantity) throws PersistenceException{
        this.handleAbsQuantity(compoundQuantity);
    }
    public abstract void handleMQuantiObjectType(PersistentMQuantiObjectType mQuantiObjectType) throws PersistenceException;
    
    public void handleMMeasurementType(PersistentMMeasurementType mMeasurementType) throws PersistenceException{
        this.handleMQuantiObjectType(mMeasurementType);
    }
    public void handleMAccountType(PersistentMAccountType mAccountType) throws PersistenceException{
        this.handleMQuantiObjectType(mAccountType);
    }
    public abstract void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException;
    
    public abstract void handleAccountTypeManager(PersistentAccountTypeManager accountTypeManager) throws PersistenceException;
    
    public abstract void handleNameSchemeInstance(PersistentNameSchemeInstance nameSchemeInstance) throws PersistenceException;
    
    public abstract void handleLinkManager(PersistentLinkManager linkManager) throws PersistenceException;
    
    public abstract void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    
    public void handleFinishModelingCommand(PersistentFinishModelingCommand finishModelingCommand) throws PersistenceException{
        this.handleCommonDate(finishModelingCommand);
    }
    public void handleCreateInstanceCommand(PersistentCreateInstanceCommand createInstanceCommand) throws PersistenceException{
        this.handleCommonDate(createInstanceCommand);
    }
    public void handleRemoveLinkCommand(PersistentRemoveLinkCommand removeLinkCommand) throws PersistenceException{
        this.handleCommonDate(removeLinkCommand);
    }
    public void handleCreateMObjectCommand(PersistentCreateMObjectCommand createMObjectCommand) throws PersistenceException{
        this.handleCommonDate(createMObjectCommand);
    }
    public void handleAddTypeCommand(PersistentAddTypeCommand addTypeCommand) throws PersistenceException{
        this.handleCommonDate(addTypeCommand);
    }
    public void handleCreateHierarchyCommand(PersistentCreateHierarchyCommand createHierarchyCommand) throws PersistenceException{
        this.handleCommonDate(createHierarchyCommand);
    }
    public void handleCreateProductTypeCommand(PersistentCreateProductTypeCommand createProductTypeCommand) throws PersistenceException{
        this.handleCommonDate(createProductTypeCommand);
    }
    public void handleCreateStaticOpCommand(PersistentCreateStaticOpCommand createStaticOpCommand) throws PersistenceException{
        this.handleCommonDate(createStaticOpCommand);
    }
    public void handleCreateUnitTypeCommand(PersistentCreateUnitTypeCommand createUnitTypeCommand) throws PersistenceException{
        this.handleCommonDate(createUnitTypeCommand);
    }
    public void handleRemoveUnitTypeCommand(PersistentRemoveUnitTypeCommand removeUnitTypeCommand) throws PersistenceException{
        this.handleCommonDate(removeUnitTypeCommand);
    }
    public void handleCreateMeasurementTypeCommand(PersistentCreateMeasurementTypeCommand createMeasurementTypeCommand) throws PersistenceException{
        this.handleCommonDate(createMeasurementTypeCommand);
    }
    public void handleCreateAccountCommand(PersistentCreateAccountCommand createAccountCommand) throws PersistenceException{
        this.handleCommonDate(createAccountCommand);
    }
    public void handleCreateAtomicSubTypeCommand(PersistentCreateAtomicSubTypeCommand createAtomicSubTypeCommand) throws PersistenceException{
        this.handleCommonDate(createAtomicSubTypeCommand);
    }
    public void handleAddMultipleFpCommand(PersistentAddMultipleFpCommand addMultipleFpCommand) throws PersistenceException{
        this.handleCommonDate(addMultipleFpCommand);
    }
    public void handleCreateVoidOperationCommand(PersistentCreateVoidOperationCommand createVoidOperationCommand) throws PersistenceException{
        this.handleCommonDate(createVoidOperationCommand);
    }
    public void handleCreateLinkCommand(PersistentCreateLinkCommand createLinkCommand) throws PersistenceException{
        this.handleCommonDate(createLinkCommand);
    }
    public void handleCreateUnitCommand(PersistentCreateUnitCommand createUnitCommand) throws PersistenceException{
        this.handleCommonDate(createUnitCommand);
    }
    public void handleCreateAspectCommand(PersistentCreateAspectCommand createAspectCommand) throws PersistenceException{
        this.handleCommonDate(createAspectCommand);
    }
    public void handleCreateCompUnitCommand(PersistentCreateCompUnitCommand createCompUnitCommand) throws PersistenceException{
        this.handleCommonDate(createCompUnitCommand);
    }
    public void handleSetDefaultUnitCommand(PersistentSetDefaultUnitCommand setDefaultUnitCommand) throws PersistenceException{
        this.handleCommonDate(setDefaultUnitCommand);
    }
    public void handleCreateCompUnitTypeCommand(PersistentCreateCompUnitTypeCommand createCompUnitTypeCommand) throws PersistenceException{
        this.handleCommonDate(createCompUnitTypeCommand);
    }
    public void handleCreateAssociationCommand(PersistentCreateAssociationCommand createAssociationCommand) throws PersistenceException{
        this.handleCommonDate(createAssociationCommand);
    }
    public void handleRemoveTypeCommand(PersistentRemoveTypeCommand removeTypeCommand) throws PersistenceException{
        this.handleCommonDate(removeTypeCommand);
    }
    public void handleCreateQuantityCommand(PersistentCreateQuantityCommand createQuantityCommand) throws PersistenceException{
        this.handleCommonDate(createQuantityCommand);
    }
    public void handleRemoveAssociationCommand(PersistentRemoveAssociationCommand removeAssociationCommand) throws PersistenceException{
        this.handleCommonDate(removeAssociationCommand);
    }
    public void handleRemoveFpCommand(PersistentRemoveFpCommand removeFpCommand) throws PersistenceException{
        this.handleCommonDate(removeFpCommand);
    }
    public void handleCreateAtomicRootTypeCommand(PersistentCreateAtomicRootTypeCommand createAtomicRootTypeCommand) throws PersistenceException{
        this.handleCommonDate(createAtomicRootTypeCommand);
    }
    public void handleAddFpCommand(PersistentAddFpCommand addFpCommand) throws PersistenceException{
        this.handleCommonDate(addFpCommand);
    }
    public void handleCreateStaticMessageCommand(PersistentCreateStaticMessageCommand createStaticMessageCommand) throws PersistenceException{
        this.handleCommonDate(createStaticMessageCommand);
    }
    public void handleAddReferenceTypeCommand(PersistentAddReferenceTypeCommand addReferenceTypeCommand) throws PersistenceException{
        this.handleCommonDate(addReferenceTypeCommand);
    }
    public void handleCreateVoidMessageCommand(PersistentCreateVoidMessageCommand createVoidMessageCommand) throws PersistenceException{
        this.handleCommonDate(createVoidMessageCommand);
    }
    public void handleRemoveAssoFrmHierCommand(PersistentRemoveAssoFrmHierCommand removeAssoFrmHierCommand) throws PersistenceException{
        this.handleCommonDate(removeAssoFrmHierCommand);
    }
    public void handleAddAssociationCommand(PersistentAddAssociationCommand addAssociationCommand) throws PersistenceException{
        this.handleCommonDate(addAssociationCommand);
    }
    public void handleReplaceTypeCommand(PersistentReplaceTypeCommand replaceTypeCommand) throws PersistenceException{
        this.handleCommonDate(replaceTypeCommand);
    }
    public void handleSetConversionCommand(PersistentSetConversionCommand setConversionCommand) throws PersistenceException{
        this.handleCommonDate(setConversionCommand);
    }
    public void handleRemoveOperationCommand(PersistentRemoveOperationCommand removeOperationCommand) throws PersistenceException{
        this.handleCommonDate(removeOperationCommand);
    }
    public void handleCreateConstCommand(PersistentCreateConstCommand createConstCommand) throws PersistenceException{
        this.handleCommonDate(createConstCommand);
    }
    public void handleCreateConstantCommand(PersistentCreateConstantCommand createConstantCommand) throws PersistenceException{
        this.handleCommonDate(createConstantCommand);
    }
    public void handleAddReferenceCommand(PersistentAddReferenceCommand addReferenceCommand) throws PersistenceException{
        this.handleCommonDate(addReferenceCommand);
    }
    public void handleCreateSumTypeCommand(PersistentCreateSumTypeCommand createSumTypeCommand) throws PersistenceException{
        this.handleCommonDate(createSumTypeCommand);
    }
    public void handleAssignNameSchemeCommand(PersistentAssignNameSchemeCommand assignNameSchemeCommand) throws PersistenceException{
        this.handleCommonDate(assignNameSchemeCommand);
    }
    public void handleCreateOperationCommand(PersistentCreateOperationCommand createOperationCommand) throws PersistenceException{
        this.handleCommonDate(createOperationCommand);
    }
    public void handleRemoveFpFromOpCommand(PersistentRemoveFpFromOpCommand removeFpFromOpCommand) throws PersistenceException{
        this.handleCommonDate(removeFpFromOpCommand);
    }
    public void handleRemoveUnitCommand(PersistentRemoveUnitCommand removeUnitCommand) throws PersistenceException{
        this.handleCommonDate(removeUnitCommand);
    }
    public void handleCreateNameSchemeCommand(PersistentCreateNameSchemeCommand createNameSchemeCommand) throws PersistenceException{
        this.handleCommonDate(createNameSchemeCommand);
    }
    public void handleAssignNameCommand(PersistentAssignNameCommand assignNameCommand) throws PersistenceException{
        this.handleCommonDate(assignNameCommand);
    }
    public void handleRemoveMessageCommand(PersistentRemoveMessageCommand removeMessageCommand) throws PersistenceException{
        this.handleCommonDate(removeMessageCommand);
    }
    public void handleCreateMessageCommand(PersistentCreateMessageCommand createMessageCommand) throws PersistenceException{
        this.handleCommonDate(createMessageCommand);
    }
    public void handleCreateAccountTypeCommand(PersistentCreateAccountTypeCommand createAccountTypeCommand) throws PersistenceException{
        this.handleCommonDate(createAccountTypeCommand);
    }
    public void handleCreateFpCommand(PersistentCreateFpCommand createFpCommand) throws PersistenceException{
        this.handleCommonDate(createFpCommand);
    }
    public abstract void handleMObject(PersistentMObject mObject) throws PersistenceException;
    
    public abstract void handleMessageOrLink(PersistentMessageOrLink messageOrLink) throws PersistenceException;
    
    public void handleLink(PersistentLink link) throws PersistenceException{
        this.handleMessageOrLink(link);
    }
    public void handleMessage(PersistentMessage message) throws PersistenceException{
        this.handleMessageOrLink(message);
    }
    public abstract void handleAbsOperation(PersistentAbsOperation absOperation) throws PersistenceException;
    
    public void handleOperation(PersistentOperation operation) throws PersistenceException{
        this.handleAbsOperation(operation);
    }
    public void handleAssociation(PersistentAssociation association) throws PersistenceException{
        this.handleAbsOperation(association);
    }
    public abstract void handleInstanceObject(PersistentInstanceObject instanceObject) throws PersistenceException;
    
    public abstract void handleHierarchy(PersistentHierarchy hierarchy) throws PersistenceException;
    
    public abstract void handleMBoolean(PersistentMBoolean mBoolean) throws PersistenceException;
    
    public void handleMFalse(PersistentMFalse mFalse) throws PersistenceException{
        this.handleMBoolean(mFalse);
    }
    public void handleMTrue(PersistentMTrue mTrue) throws PersistenceException{
        this.handleMBoolean(mTrue);
    }
    public abstract void handleTypeManager(PersistentTypeManager typeManager) throws PersistenceException;
    
    public abstract void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException;
    
    public abstract void handleMessageManager(PersistentMessageManager messageManager) throws PersistenceException;
    
    public abstract void handleNameInstance(PersistentNameInstance nameInstance) throws PersistenceException;
    
    public abstract void handleUnitTypeManager(PersistentUnitTypeManager unitTypeManager) throws PersistenceException;
    
    public abstract void handleMType(PersistentMType mType) throws PersistenceException;
    
    public void handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException{
        this.handleMType(mAtomicType);
    }
    public void handleMProductType(PersistentMProductType mProductType) throws PersistenceException{
        this.handleMType(mProductType);
    }
    public void handleMEmptySumType(PersistentMEmptySumType mEmptySumType) throws PersistenceException{
        this.handleMType(mEmptySumType);
    }
    public void handleMSumType(PersistentMSumType mSumType) throws PersistenceException{
        this.handleMType(mSumType);
    }
    public void handleMEmptyProductType(PersistentMEmptyProductType mEmptyProductType) throws PersistenceException{
        this.handleMType(mEmptyProductType);
    }
    public abstract void handleNameSchemeInstaceManager(PersistentNameSchemeInstaceManager nameSchemeInstaceManager) throws PersistenceException;
    
    public abstract void handleFunction(PersistentFunction function) throws PersistenceException;
    
    public abstract void handleAbsUnit(PersistentAbsUnit absUnit) throws PersistenceException;
    
    public void handleCompUnit(PersistentCompUnit compUnit) throws PersistenceException{
        this.handleAbsUnit(compUnit);
    }
    public void handleUnit(PersistentUnit unit) throws PersistenceException{
        this.handleAbsUnit(unit);
    }
    public abstract void handleAspectManager(PersistentAspectManager aspectManager) throws PersistenceException;
    
    public abstract void handleActualParameter(PersistentActualParameter actualParameter) throws PersistenceException;
    
    public abstract void handleNameScheme(PersistentNameScheme nameScheme) throws PersistenceException;
    
    public abstract void handleServer(PersistentServer server) throws PersistenceException;
    
    public abstract void handleName(PersistentName name) throws PersistenceException;
    
    public abstract void handleFractionManager(PersistentFractionManager fractionManager) throws PersistenceException;
    
    public abstract void handleMAspect(PersistentMAspect mAspect) throws PersistenceException;
    
    public abstract void handleAccountManager(PersistentAccountManager accountManager) throws PersistenceException;
    
    public abstract void handleFunctionManager(PersistentFunctionManager functionManager) throws PersistenceException;
    
    public abstract void handleConversion(PersistentConversion conversion) throws PersistenceException;
    
    public abstract void handleReference(PersistentReference reference) throws PersistenceException;
    
    public abstract void handleObjectManager(PersistentObjectManager objectManager) throws PersistenceException;
    
    
}
