
package model.visitor;

import persistence.*;

public interface CommonDateReturnVisitor<R> {
    
    public R handleAddTypeCommand(PersistentAddTypeCommand addTypeCommand) throws PersistenceException;
    public R handleCreateMObjectCommand(PersistentCreateMObjectCommand createMObjectCommand) throws PersistenceException;
    public R handleCreateUnitTypeCommand(PersistentCreateUnitTypeCommand createUnitTypeCommand) throws PersistenceException;
    public R handleCreateAspectCommand(PersistentCreateAspectCommand createAspectCommand) throws PersistenceException;
    public R handleCreateUnitCommand(PersistentCreateUnitCommand createUnitCommand) throws PersistenceException;
    public R handleRemoveTypeCommand(PersistentRemoveTypeCommand removeTypeCommand) throws PersistenceException;
    public R handleAddDefaultUnitCommand(PersistentAddDefaultUnitCommand addDefaultUnitCommand) throws PersistenceException;
    public R handleRemoveAssoFrmHierCommand(PersistentRemoveAssoFrmHierCommand removeAssoFrmHierCommand) throws PersistenceException;
    public R handleAssignNameCommand(PersistentAssignNameCommand assignNameCommand) throws PersistenceException;
    public R handleCreateInstanceCommand(PersistentCreateInstanceCommand createInstanceCommand) throws PersistenceException;
    public R handleRemoveLinkCommand(PersistentRemoveLinkCommand removeLinkCommand) throws PersistenceException;
    public R handleCreateHierarchyCommand(PersistentCreateHierarchyCommand createHierarchyCommand) throws PersistenceException;
    public R handleCreateMeasurementTypeCommand(PersistentCreateMeasurementTypeCommand createMeasurementTypeCommand) throws PersistenceException;
    public R handleCreateQuantityCommand(PersistentCreateQuantityCommand createQuantityCommand) throws PersistenceException;
    public R handleRemoveFpCommand(PersistentRemoveFpCommand removeFpCommand) throws PersistenceException;
    public R handleRemoveOperationCommand(PersistentRemoveOperationCommand removeOperationCommand) throws PersistenceException;
    public R handleCreateConstantCommand(PersistentCreateConstantCommand createConstantCommand) throws PersistenceException;
    public R handleCreateNameSchemeCommand(PersistentCreateNameSchemeCommand createNameSchemeCommand) throws PersistenceException;
    public R handleCreateMessageCommand(PersistentCreateMessageCommand createMessageCommand) throws PersistenceException;
    public R handleCreateAccountTypeCommand(PersistentCreateAccountTypeCommand createAccountTypeCommand) throws PersistenceException;
    public R handleCreateProductTypeCommand(PersistentCreateProductTypeCommand createProductTypeCommand) throws PersistenceException;
    public R handleCreateStaticOpCommand(PersistentCreateStaticOpCommand createStaticOpCommand) throws PersistenceException;
    public R handleCreateAccountCommand(PersistentCreateAccountCommand createAccountCommand) throws PersistenceException;
    public R handleCreateConversionCommand(PersistentCreateConversionCommand createConversionCommand) throws PersistenceException;
    public R handleCreateAtomicSubTypeCommand(PersistentCreateAtomicSubTypeCommand createAtomicSubTypeCommand) throws PersistenceException;
    public R handleCreateLinkCommand(PersistentCreateLinkCommand createLinkCommand) throws PersistenceException;
    public R handleCreateVoidOperationCommand(PersistentCreateVoidOperationCommand createVoidOperationCommand) throws PersistenceException;
    public R handleCreateCompUnitCommand(PersistentCreateCompUnitCommand createCompUnitCommand) throws PersistenceException;
    public R handleCreateCompUnitTypeCommand(PersistentCreateCompUnitTypeCommand createCompUnitTypeCommand) throws PersistenceException;
    public R handleRemoveAssociationCommand(PersistentRemoveAssociationCommand removeAssociationCommand) throws PersistenceException;
    public R handleAddFpCommand(PersistentAddFpCommand addFpCommand) throws PersistenceException;
    public R handleCreateStaticMessageCommand(PersistentCreateStaticMessageCommand createStaticMessageCommand) throws PersistenceException;
    public R handleCreateVoidMessageCommand(PersistentCreateVoidMessageCommand createVoidMessageCommand) throws PersistenceException;
    public R handleAddAssociationCommand(PersistentAddAssociationCommand addAssociationCommand) throws PersistenceException;
    public R handleReplaceTypeCommand(PersistentReplaceTypeCommand replaceTypeCommand) throws PersistenceException;
    public R handleCreateConstCommand(PersistentCreateConstCommand createConstCommand) throws PersistenceException;
    public R handleAssignNameSchemeCommand(PersistentAssignNameSchemeCommand assignNameSchemeCommand) throws PersistenceException;
    public R handleCreateOperationCommand(PersistentCreateOperationCommand createOperationCommand) throws PersistenceException;
    public R handleFinishModelingCommand(PersistentFinishModelingCommand finishModelingCommand) throws PersistenceException;
    public R handleAddMultipleFpCommand(PersistentAddMultipleFpCommand addMultipleFpCommand) throws PersistenceException;
    public R handleCreateAssociationCommand(PersistentCreateAssociationCommand createAssociationCommand) throws PersistenceException;
    public R handleCreateAtomicRootTypeCommand(PersistentCreateAtomicRootTypeCommand createAtomicRootTypeCommand) throws PersistenceException;
    public R handleAddReferenceTypeCommand(PersistentAddReferenceTypeCommand addReferenceTypeCommand) throws PersistenceException;
    public R handleCreateSumTypeCommand(PersistentCreateSumTypeCommand createSumTypeCommand) throws PersistenceException;
    public R handleRemoveFpFromOpCommand(PersistentRemoveFpFromOpCommand removeFpFromOpCommand) throws PersistenceException;
    public R handleRemoveMessageCommand(PersistentRemoveMessageCommand removeMessageCommand) throws PersistenceException;
    public R handleCreateFpCommand(PersistentCreateFpCommand createFpCommand) throws PersistenceException;
    public R handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    
}
