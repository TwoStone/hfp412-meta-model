
package model.visitor;
import model.UserException;
import persistence.*;

public interface CommonDateReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleCreateMObjectCommand(PersistentCreateMObjectCommand createMObjectCommand) throws PersistenceException, E;
    public R handleCreateUnitTypeCommand(PersistentCreateUnitTypeCommand createUnitTypeCommand) throws PersistenceException, E;
    public R handleCreateAspectCommand(PersistentCreateAspectCommand createAspectCommand) throws PersistenceException, E;
    public R handleCreateUnitCommand(PersistentCreateUnitCommand createUnitCommand) throws PersistenceException, E;
    public R handleAddDefaultUnitCommand(PersistentAddDefaultUnitCommand addDefaultUnitCommand) throws PersistenceException, E;
    public R handleRemoveAssoFrmHierCommand(PersistentRemoveAssoFrmHierCommand removeAssoFrmHierCommand) throws PersistenceException, E;
    public R handleRemoveLinkCommand(PersistentRemoveLinkCommand removeLinkCommand) throws PersistenceException, E;
    public R handleCreateHierarchyCommand(PersistentCreateHierarchyCommand createHierarchyCommand) throws PersistenceException, E;
    public R handleCreateMeasurementTypeCommand(PersistentCreateMeasurementTypeCommand createMeasurementTypeCommand) throws PersistenceException, E;
    public R handleCreateQuantityCommand(PersistentCreateQuantityCommand createQuantityCommand) throws PersistenceException, E;
    public R handleRemoveFpCommand(PersistentRemoveFpCommand removeFpCommand) throws PersistenceException, E;
    public R handleRemoveOperationCommand(PersistentRemoveOperationCommand removeOperationCommand) throws PersistenceException, E;
    public R handleCreateConstantCommand(PersistentCreateConstantCommand createConstantCommand) throws PersistenceException, E;
    public R handleCreateMessageCommand(PersistentCreateMessageCommand createMessageCommand) throws PersistenceException, E;
    public R handleCreateAccountTypeCommand(PersistentCreateAccountTypeCommand createAccountTypeCommand) throws PersistenceException, E;
    public R handleCreateProductTypeCommand(PersistentCreateProductTypeCommand createProductTypeCommand) throws PersistenceException, E;
    public R handleCreateStaticOpCommand(PersistentCreateStaticOpCommand createStaticOpCommand) throws PersistenceException, E;
    public R handleCreateAccountCommand(PersistentCreateAccountCommand createAccountCommand) throws PersistenceException, E;
    public R handleCreateConversionCommand(PersistentCreateConversionCommand createConversionCommand) throws PersistenceException, E;
    public R handleCreateAtomicSubTypeCommand(PersistentCreateAtomicSubTypeCommand createAtomicSubTypeCommand) throws PersistenceException, E;
    public R handleCreateVoidOperationCommand(PersistentCreateVoidOperationCommand createVoidOperationCommand) throws PersistenceException, E;
    public R handleCreateLinkCommand(PersistentCreateLinkCommand createLinkCommand) throws PersistenceException, E;
    public R handleCreateCompUnitCommand(PersistentCreateCompUnitCommand createCompUnitCommand) throws PersistenceException, E;
    public R handleCreateCompUnitTypeCommand(PersistentCreateCompUnitTypeCommand createCompUnitTypeCommand) throws PersistenceException, E;
    public R handleRemoveAssociationCommand(PersistentRemoveAssociationCommand removeAssociationCommand) throws PersistenceException, E;
    public R handleAddFpCommand(PersistentAddFpCommand addFpCommand) throws PersistenceException, E;
    public R handleCreateStaticMessageCommand(PersistentCreateStaticMessageCommand createStaticMessageCommand) throws PersistenceException, E;
    public R handleCreateVoidMessageCommand(PersistentCreateVoidMessageCommand createVoidMessageCommand) throws PersistenceException, E;
    public R handleAddAssociationCommand(PersistentAddAssociationCommand addAssociationCommand) throws PersistenceException, E;
    public R handleCreateConstCommand(PersistentCreateConstCommand createConstCommand) throws PersistenceException, E;
    public R handleCreateOperationCommand(PersistentCreateOperationCommand createOperationCommand) throws PersistenceException, E;
    public R handleFinishModelingCommand(PersistentFinishModelingCommand finishModelingCommand) throws PersistenceException, E;
    public R handleCreateAssociationCommand(PersistentCreateAssociationCommand createAssociationCommand) throws PersistenceException, E;
    public R handleCreateAtomicRootTypeCommand(PersistentCreateAtomicRootTypeCommand createAtomicRootTypeCommand) throws PersistenceException, E;
    public R handleAddReferenceTypeCommand(PersistentAddReferenceTypeCommand addReferenceTypeCommand) throws PersistenceException, E;
    public R handleAddSubTypeCommand(PersistentAddSubTypeCommand addSubTypeCommand) throws PersistenceException, E;
    public R handleCreateSumTypeCommand(PersistentCreateSumTypeCommand createSumTypeCommand) throws PersistenceException, E;
    public R handleRemoveFpFromOpCommand(PersistentRemoveFpFromOpCommand removeFpFromOpCommand) throws PersistenceException, E;
    public R handleRemoveMessageCommand(PersistentRemoveMessageCommand removeMessageCommand) throws PersistenceException, E;
    public R handleCreateFpCommand(PersistentCreateFpCommand createFpCommand) throws PersistenceException, E;
    public R handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException, E;
    
}
