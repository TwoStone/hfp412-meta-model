
package model.visitor;

import persistence.*;

public interface AnythingVisitor extends AbsOperationVisitor,QuantifObjectVisitor,MQuantiObjectTypeVisitor,MBooleanVisitor,AbsUnitTypeVisitor,AbsQuantityVisitor,CommonDateVisitor,MTypeVisitor,AbsUnitVisitor,MessageOrLinkVisitor{
    
    public void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException;
    public void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException;
    public void handleCreateMObjectCommand(PersistentCreateMObjectCommand createMObjectCommand) throws PersistenceException;
    public void handleCreateUnitTypeCommand(PersistentCreateUnitTypeCommand createUnitTypeCommand) throws PersistenceException;
    public void handleCreateAspectCommand(PersistentCreateAspectCommand createAspectCommand) throws PersistenceException;
    public void handleCreateUnitCommand(PersistentCreateUnitCommand createUnitCommand) throws PersistenceException;
    public void handleAddDefaultUnitCommand(PersistentAddDefaultUnitCommand addDefaultUnitCommand) throws PersistenceException;
    public void handleRemoveAssoFrmHierCommand(PersistentRemoveAssoFrmHierCommand removeAssoFrmHierCommand) throws PersistenceException;
    public void handleServer(PersistentServer server) throws PersistenceException;
    public void handleAssociation(PersistentAssociation association) throws PersistenceException;
    public void handleRemoveLinkCommand(PersistentRemoveLinkCommand removeLinkCommand) throws PersistenceException;
    public void handleFormalParameter(PersistentFormalParameter formalParameter) throws PersistenceException;
    public void handleCreateHierarchyCommand(PersistentCreateHierarchyCommand createHierarchyCommand) throws PersistenceException;
    public void handleOperationManager(PersistentOperationManager operationManager) throws PersistenceException;
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public void handleCreateMeasurementTypeCommand(PersistentCreateMeasurementTypeCommand createMeasurementTypeCommand) throws PersistenceException;
    public void handleAccountTypeManager(PersistentAccountTypeManager accountTypeManager) throws PersistenceException;
    public void handleMObject(PersistentMObject mObject) throws PersistenceException;
    public void handleCreateQuantityCommand(PersistentCreateQuantityCommand createQuantityCommand) throws PersistenceException;
    public void handleInstanceObject(PersistentInstanceObject instanceObject) throws PersistenceException;
    public void handleRemoveFpCommand(PersistentRemoveFpCommand removeFpCommand) throws PersistenceException;
    public void handleFunction(PersistentFunction function) throws PersistenceException;
    public void handleAspectManager(PersistentAspectManager aspectManager) throws PersistenceException;
    public void handleRemoveOperationCommand(PersistentRemoveOperationCommand removeOperationCommand) throws PersistenceException;
    public void handleCreateConstantCommand(PersistentCreateConstantCommand createConstantCommand) throws PersistenceException;
    public void handleMAspect(PersistentMAspect mAspect) throws PersistenceException;
    public void handleAccountManager(PersistentAccountManager accountManager) throws PersistenceException;
    public void handleCreateMessageCommand(PersistentCreateMessageCommand createMessageCommand) throws PersistenceException;
    public void handleCreateAccountTypeCommand(PersistentCreateAccountTypeCommand createAccountTypeCommand) throws PersistenceException;
    public void handleConversionManager(PersistentConversionManager conversionManager) throws PersistenceException;
    public void handleQuantityManager(PersistentQuantityManager quantityManager) throws PersistenceException;
    public void handleCreateProductTypeCommand(PersistentCreateProductTypeCommand createProductTypeCommand) throws PersistenceException;
    public void handleCreateStaticOpCommand(PersistentCreateStaticOpCommand createStaticOpCommand) throws PersistenceException;
    public void handleAssociationManager(PersistentAssociationManager associationManager) throws PersistenceException;
    public void handleCreateAccountCommand(PersistentCreateAccountCommand createAccountCommand) throws PersistenceException;
    public void handleCreateConversionCommand(PersistentCreateConversionCommand createConversionCommand) throws PersistenceException;
    public void handleCreateAtomicSubTypeCommand(PersistentCreateAtomicSubTypeCommand createAtomicSubTypeCommand) throws PersistenceException;
    public void handleCreateVoidOperationCommand(PersistentCreateVoidOperationCommand createVoidOperationCommand) throws PersistenceException;
    public void handleCreateLinkCommand(PersistentCreateLinkCommand createLinkCommand) throws PersistenceException;
    public void handleCreateCompUnitCommand(PersistentCreateCompUnitCommand createCompUnitCommand) throws PersistenceException;
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    public void handleCreateCompUnitTypeCommand(PersistentCreateCompUnitTypeCommand createCompUnitTypeCommand) throws PersistenceException;
    public void handleRemoveAssociationCommand(PersistentRemoveAssociationCommand removeAssociationCommand) throws PersistenceException;
    public void handleHierarchy(PersistentHierarchy hierarchy) throws PersistenceException;
    public void handleAddFpCommand(PersistentAddFpCommand addFpCommand) throws PersistenceException;
    public void handleCreateStaticMessageCommand(PersistentCreateStaticMessageCommand createStaticMessageCommand) throws PersistenceException;
    public void handleTypeManager(PersistentTypeManager typeManager) throws PersistenceException;
    public void handleMessageManager(PersistentMessageManager messageManager) throws PersistenceException;
    public void handleUnitTypeManager(PersistentUnitTypeManager unitTypeManager) throws PersistenceException;
    public void handleCreateVoidMessageCommand(PersistentCreateVoidMessageCommand createVoidMessageCommand) throws PersistenceException;
    public void handleAddAssociationCommand(PersistentAddAssociationCommand addAssociationCommand) throws PersistenceException;
    public void handleCreateConstCommand(PersistentCreateConstCommand createConstCommand) throws PersistenceException;
    public void handleFractionManager(PersistentFractionManager fractionManager) throws PersistenceException;
    public void handleCreateOperationCommand(PersistentCreateOperationCommand createOperationCommand) throws PersistenceException;
    public void handleConversion(PersistentConversion conversion) throws PersistenceException;
    public void handleReference(PersistentReference reference) throws PersistenceException;
    public void handleFinishModelingCommand(PersistentFinishModelingCommand finishModelingCommand) throws PersistenceException;
    public void handleReferenceType(PersistentReferenceType referenceType) throws PersistenceException;
    public void handleMeasurementTypeManager(PersistentMeasurementTypeManager measurementTypeManager) throws PersistenceException;
    public void handleLinkManager(PersistentLinkManager linkManager) throws PersistenceException;
    public void handleCreateAssociationCommand(PersistentCreateAssociationCommand createAssociationCommand) throws PersistenceException;
    public void handleCreateAtomicRootTypeCommand(PersistentCreateAtomicRootTypeCommand createAtomicRootTypeCommand) throws PersistenceException;
    public void handleAddReferenceTypeCommand(PersistentAddReferenceTypeCommand addReferenceTypeCommand) throws PersistenceException;
    public void handleActualParameter(PersistentActualParameter actualParameter) throws PersistenceException;
    public void handleAddSubTypeCommand(PersistentAddSubTypeCommand addSubTypeCommand) throws PersistenceException;
    public void handleCreateSumTypeCommand(PersistentCreateSumTypeCommand createSumTypeCommand) throws PersistenceException;
    public void handleRemoveFpFromOpCommand(PersistentRemoveFpFromOpCommand removeFpFromOpCommand) throws PersistenceException;
    public void handleRemoveMessageCommand(PersistentRemoveMessageCommand removeMessageCommand) throws PersistenceException;
    public void handleObjectManager(PersistentObjectManager objectManager) throws PersistenceException;
    public void handleCreateFpCommand(PersistentCreateFpCommand createFpCommand) throws PersistenceException;
    
}
