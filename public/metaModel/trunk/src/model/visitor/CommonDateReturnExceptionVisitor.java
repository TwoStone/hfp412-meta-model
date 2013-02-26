
package model.visitor;
import model.UserException;
import persistence.*;

public interface CommonDateReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleConvertToDefaultCommand(PersistentConvertToDefaultCommand convertToDefaultCommand) throws PersistenceException, E;
    public R handleCreateMObjectCommand(PersistentCreateMObjectCommand createMObjectCommand) throws PersistenceException, E;
    public R handleAddTypeCommand(PersistentAddTypeCommand addTypeCommand) throws PersistenceException, E;
    public R handleAssignTypeCommand(PersistentAssignTypeCommand assignTypeCommand) throws PersistenceException, E;
    public R handleCreateUnitTypeCommand(PersistentCreateUnitTypeCommand createUnitTypeCommand) throws PersistenceException, E;
    public R handleRemoveUnitTypeCommand(PersistentRemoveUnitTypeCommand removeUnitTypeCommand) throws PersistenceException, E;
    public R handleCreateAspectCommand(PersistentCreateAspectCommand createAspectCommand) throws PersistenceException, E;
    public R handleCreateUnitCommand(PersistentCreateUnitCommand createUnitCommand) throws PersistenceException, E;
    public R handleCreateTypeDisjunctionCommand(PersistentCreateTypeDisjunctionCommand createTypeDisjunctionCommand) throws PersistenceException, E;
    public R handleRemoveTypeCommand(PersistentRemoveTypeCommand removeTypeCommand) throws PersistenceException, E;
    public R handleRemoveAssoFrmHierCommand(PersistentRemoveAssoFrmHierCommand removeAssoFrmHierCommand) throws PersistenceException, E;
    public R handleSetConversionCommand(PersistentSetConversionCommand setConversionCommand) throws PersistenceException, E;
    public R handleCreateTypeConjunctionCommand(PersistentCreateTypeConjunctionCommand createTypeConjunctionCommand) throws PersistenceException, E;
    public R handleAssignNameCommand(PersistentAssignNameCommand assignNameCommand) throws PersistenceException, E;
    public R handleAggregateCommand(PersistentAggregateCommand aggregateCommand) throws PersistenceException, E;
    public R handleAddSubAccountTypeCommand(PersistentAddSubAccountTypeCommand addSubAccountTypeCommand) throws PersistenceException, E;
    public R handleRemoveLinkCommand(PersistentRemoveLinkCommand removeLinkCommand) throws PersistenceException, E;
    public R handleCreateHierarchyCommand(PersistentCreateHierarchyCommand createHierarchyCommand) throws PersistenceException, E;
    public R handleCreateMeasurementTypeCommand(PersistentCreateMeasurementTypeCommand createMeasurementTypeCommand) throws PersistenceException, E;
    public R handleCreateQuantityCommand(PersistentCreateQuantityCommand createQuantityCommand) throws PersistenceException, E;
    public R handleRemoveFpCommand(PersistentRemoveFpCommand removeFpCommand) throws PersistenceException, E;
    public R handleRemoveOperationCommand(PersistentRemoveOperationCommand removeOperationCommand) throws PersistenceException, E;
    public R handleCreateConstantCommand(PersistentCreateConstantCommand createConstantCommand) throws PersistenceException, E;
    public R handleAddReferenceCommand(PersistentAddReferenceCommand addReferenceCommand) throws PersistenceException, E;
    public R handleCreateNameSchemeCommand(PersistentCreateNameSchemeCommand createNameSchemeCommand) throws PersistenceException, E;
    public R handleAddEntryCommand(PersistentAddEntryCommand addEntryCommand) throws PersistenceException, E;
    public R handleCreateMessageCommand(PersistentCreateMessageCommand createMessageCommand) throws PersistenceException, E;
    public R handleCreateAccountTypeCommand(PersistentCreateAccountTypeCommand createAccountTypeCommand) throws PersistenceException, E;
    public R handleCreateStaticOpCommand(PersistentCreateStaticOpCommand createStaticOpCommand) throws PersistenceException, E;
    public R handleCreateAccountCommand(PersistentCreateAccountCommand createAccountCommand) throws PersistenceException, E;
    public R handleCreateAtomicSubTypeCommand(PersistentCreateAtomicSubTypeCommand createAtomicSubTypeCommand) throws PersistenceException, E;
    public R handleCreateLinkCommand(PersistentCreateLinkCommand createLinkCommand) throws PersistenceException, E;
    public R handleCreateVoidOperationCommand(PersistentCreateVoidOperationCommand createVoidOperationCommand) throws PersistenceException, E;
    public R handleSetDefaultUnitCommand(PersistentSetDefaultUnitCommand setDefaultUnitCommand) throws PersistenceException, E;
    public R handleCreateCompUnitCommand(PersistentCreateCompUnitCommand createCompUnitCommand) throws PersistenceException, E;
    public R handleCreateCompUnitTypeCommand(PersistentCreateCompUnitTypeCommand createCompUnitTypeCommand) throws PersistenceException, E;
    public R handleRemoveAssociationCommand(PersistentRemoveAssociationCommand removeAssociationCommand) throws PersistenceException, E;
    public R handleAddFpCommand(PersistentAddFpCommand addFpCommand) throws PersistenceException, E;
    public R handleCreateStaticMessageCommand(PersistentCreateStaticMessageCommand createStaticMessageCommand) throws PersistenceException, E;
    public R handleCreateVoidMessageCommand(PersistentCreateVoidMessageCommand createVoidMessageCommand) throws PersistenceException, E;
    public R handleAddAssociationCommand(PersistentAddAssociationCommand addAssociationCommand) throws PersistenceException, E;
    public R handleReplaceTypeCommand(PersistentReplaceTypeCommand replaceTypeCommand) throws PersistenceException, E;
    public R handleCreateConstCommand(PersistentCreateConstCommand createConstCommand) throws PersistenceException, E;
    public R handleCreateOperationCommand(PersistentCreateOperationCommand createOperationCommand) throws PersistenceException, E;
    public R handleRemoveUnitCommand(PersistentRemoveUnitCommand removeUnitCommand) throws PersistenceException, E;
    public R handleAddMultipleFpCommand(PersistentAddMultipleFpCommand addMultipleFpCommand) throws PersistenceException, E;
    public R handleCreateAssociationCommand(PersistentCreateAssociationCommand createAssociationCommand) throws PersistenceException, E;
    public R handleCreateAtomicRootTypeCommand(PersistentCreateAtomicRootTypeCommand createAtomicRootTypeCommand) throws PersistenceException, E;
    public R handleConvertCommand(PersistentConvertCommand convertCommand) throws PersistenceException, E;
    public R handleAddReferenceTypeCommand(PersistentAddReferenceTypeCommand addReferenceTypeCommand) throws PersistenceException, E;
    public R handleAddSubAccountCommand(PersistentAddSubAccountCommand addSubAccountCommand) throws PersistenceException, E;
    public R handleAddFractionCommand(PersistentAddFractionCommand addFractionCommand) throws PersistenceException, E;
    public R handleRemoveFpFromOpCommand(PersistentRemoveFpFromOpCommand removeFpFromOpCommand) throws PersistenceException, E;
    public R handleRemoveMessageCommand(PersistentRemoveMessageCommand removeMessageCommand) throws PersistenceException, E;
    public R handleCreateFpCommand(PersistentCreateFpCommand createFpCommand) throws PersistenceException, E;
    public R handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException, E;
    
}
