
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentAddAssociationCommand;
import persistence.PersistentAddFpCommand;
import persistence.PersistentAddMultipleFpCommand;
import persistence.PersistentAddReferenceCommand;
import persistence.PersistentAddReferenceTypeCommand;
import persistence.PersistentAddTypeCommand;
import persistence.PersistentAssignNameCommand;
import persistence.PersistentAssignTypeCommand;
import persistence.PersistentCommonDate;
import persistence.PersistentCreateAccountCommand;
import persistence.PersistentCreateAccountTypeCommand;
import persistence.PersistentCreateAspectCommand;
import persistence.PersistentCreateAssociationCommand;
import persistence.PersistentCreateAtomicRootTypeCommand;
import persistence.PersistentCreateAtomicSubTypeCommand;
import persistence.PersistentCreateCompUnitCommand;
import persistence.PersistentCreateCompUnitTypeCommand;
import persistence.PersistentCreateConstCommand;
import persistence.PersistentCreateConstantCommand;
import persistence.PersistentCreateFpCommand;
import persistence.PersistentCreateHierarchyCommand;
import persistence.PersistentCreateLinkCommand;
import persistence.PersistentCreateMObjectCommand;
import persistence.PersistentCreateMeasurementTypeCommand;
import persistence.PersistentCreateMessageCommand;
import persistence.PersistentCreateNameSchemeCommand;
import persistence.PersistentCreateOperationCommand;
import persistence.PersistentCreateProductTypeCommand;
import persistence.PersistentCreateQuantityCommand;
import persistence.PersistentCreateStaticMessageCommand;
import persistence.PersistentCreateStaticOpCommand;
import persistence.PersistentCreateSumTypeCommand;
import persistence.PersistentCreateUnitCommand;
import persistence.PersistentCreateUnitTypeCommand;
import persistence.PersistentCreateVoidMessageCommand;
import persistence.PersistentCreateVoidOperationCommand;
import persistence.PersistentFinishModelingCommand;
import persistence.PersistentRemoveAssoFrmHierCommand;
import persistence.PersistentRemoveAssociationCommand;
import persistence.PersistentRemoveFpCommand;
import persistence.PersistentRemoveFpFromOpCommand;
import persistence.PersistentRemoveLinkCommand;
import persistence.PersistentRemoveMessageCommand;
import persistence.PersistentRemoveOperationCommand;
import persistence.PersistentRemoveTypeCommand;
import persistence.PersistentRemoveUnitCommand;
import persistence.PersistentRemoveUnitTypeCommand;
import persistence.PersistentReplaceTypeCommand;
import persistence.PersistentSetConversionCommand;
import persistence.PersistentSetDefaultUnitCommand;

public interface CommonDateReturnVisitor<R> {
    
    public R handleAddTypeCommand(PersistentAddTypeCommand addTypeCommand) throws PersistenceException;
    public R handleCreateMObjectCommand(PersistentCreateMObjectCommand createMObjectCommand) throws PersistenceException;
    public R handleAssignTypeCommand(PersistentAssignTypeCommand assignTypeCommand) throws PersistenceException;
    public R handleCreateUnitTypeCommand(PersistentCreateUnitTypeCommand createUnitTypeCommand) throws PersistenceException;
    public R handleRemoveUnitTypeCommand(PersistentRemoveUnitTypeCommand removeUnitTypeCommand) throws PersistenceException;
    public R handleCreateAspectCommand(PersistentCreateAspectCommand createAspectCommand) throws PersistenceException;
    public R handleCreateUnitCommand(PersistentCreateUnitCommand createUnitCommand) throws PersistenceException;
    public R handleRemoveTypeCommand(PersistentRemoveTypeCommand removeTypeCommand) throws PersistenceException;
    public R handleRemoveAssoFrmHierCommand(PersistentRemoveAssoFrmHierCommand removeAssoFrmHierCommand) throws PersistenceException;
    public R handleSetConversionCommand(PersistentSetConversionCommand setConversionCommand) throws PersistenceException;
    public R handleAssignNameCommand(PersistentAssignNameCommand assignNameCommand) throws PersistenceException;
    public R handleRemoveLinkCommand(PersistentRemoveLinkCommand removeLinkCommand) throws PersistenceException;
    public R handleCreateHierarchyCommand(PersistentCreateHierarchyCommand createHierarchyCommand) throws PersistenceException;
    public R handleCreateMeasurementTypeCommand(PersistentCreateMeasurementTypeCommand createMeasurementTypeCommand) throws PersistenceException;
    public R handleCreateQuantityCommand(PersistentCreateQuantityCommand createQuantityCommand) throws PersistenceException;
    public R handleRemoveFpCommand(PersistentRemoveFpCommand removeFpCommand) throws PersistenceException;
    public R handleRemoveOperationCommand(PersistentRemoveOperationCommand removeOperationCommand) throws PersistenceException;
    public R handleCreateConstantCommand(PersistentCreateConstantCommand createConstantCommand) throws PersistenceException;
    public R handleAddReferenceCommand(PersistentAddReferenceCommand addReferenceCommand) throws PersistenceException;
    public R handleCreateNameSchemeCommand(PersistentCreateNameSchemeCommand createNameSchemeCommand) throws PersistenceException;
    public R handleCreateMessageCommand(PersistentCreateMessageCommand createMessageCommand) throws PersistenceException;
    public R handleCreateAccountTypeCommand(PersistentCreateAccountTypeCommand createAccountTypeCommand) throws PersistenceException;
    public R handleCreateProductTypeCommand(PersistentCreateProductTypeCommand createProductTypeCommand) throws PersistenceException;
    public R handleCreateStaticOpCommand(PersistentCreateStaticOpCommand createStaticOpCommand) throws PersistenceException;
    public R handleCreateAccountCommand(PersistentCreateAccountCommand createAccountCommand) throws PersistenceException;
    public R handleCreateAtomicSubTypeCommand(PersistentCreateAtomicSubTypeCommand createAtomicSubTypeCommand) throws PersistenceException;
    public R handleCreateLinkCommand(PersistentCreateLinkCommand createLinkCommand) throws PersistenceException;
    public R handleCreateVoidOperationCommand(PersistentCreateVoidOperationCommand createVoidOperationCommand) throws PersistenceException;
    public R handleSetDefaultUnitCommand(PersistentSetDefaultUnitCommand setDefaultUnitCommand) throws PersistenceException;
    public R handleCreateCompUnitCommand(PersistentCreateCompUnitCommand createCompUnitCommand) throws PersistenceException;
    public R handleCreateCompUnitTypeCommand(PersistentCreateCompUnitTypeCommand createCompUnitTypeCommand) throws PersistenceException;
    public R handleRemoveAssociationCommand(PersistentRemoveAssociationCommand removeAssociationCommand) throws PersistenceException;
    public R handleAddFpCommand(PersistentAddFpCommand addFpCommand) throws PersistenceException;
    public R handleCreateStaticMessageCommand(PersistentCreateStaticMessageCommand createStaticMessageCommand) throws PersistenceException;
    public R handleCreateVoidMessageCommand(PersistentCreateVoidMessageCommand createVoidMessageCommand) throws PersistenceException;
    public R handleAddAssociationCommand(PersistentAddAssociationCommand addAssociationCommand) throws PersistenceException;
    public R handleReplaceTypeCommand(PersistentReplaceTypeCommand replaceTypeCommand) throws PersistenceException;
    public R handleCreateConstCommand(PersistentCreateConstCommand createConstCommand) throws PersistenceException;
    public R handleCreateOperationCommand(PersistentCreateOperationCommand createOperationCommand) throws PersistenceException;
    public R handleRemoveUnitCommand(PersistentRemoveUnitCommand removeUnitCommand) throws PersistenceException;
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
