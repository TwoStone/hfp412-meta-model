
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentAddAssociationCommand;
import persistence.PersistentAddCommand;
import persistence.PersistentAddEntryCommand;
import persistence.PersistentAddFpCommand;
import persistence.PersistentAddFractionCommand;
import persistence.PersistentAddMultipleFpCommand;
import persistence.PersistentAddReferenceCommand;
import persistence.PersistentAddReferenceTypeCommand;
import persistence.PersistentAddSubAccountCommand;
import persistence.PersistentAddSubAccountTypeCommand;
import persistence.PersistentAddTypeCommand;
import persistence.PersistentAggregateCommand;
import persistence.PersistentAssignNameCommand;
import persistence.PersistentAssignTypeCommand;
import persistence.PersistentChangeAbstractCommand;
import persistence.PersistentCommonDate;
import persistence.PersistentConvertCommand;
import persistence.PersistentConvertToDefaultCommand;
import persistence.PersistentCreateAccountCommand;
import persistence.PersistentCreateAccountTypeCommand;
import persistence.PersistentCreateAspectCommand;
import persistence.PersistentCreateAssociationCommand;
import persistence.PersistentCreateAtomicRootTypeCommand;
import persistence.PersistentCreateAtomicSubTypeCommand;
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
import persistence.PersistentCreateQuantityCommand;
import persistence.PersistentCreateStaticMessageCommand;
import persistence.PersistentCreateStaticOpCommand;
import persistence.PersistentCreateTypeConjunctionCommand;
import persistence.PersistentCreateTypeDisjunctionCommand;
import persistence.PersistentCreateUnitCommand;
import persistence.PersistentCreateUnitTypeCommand;
import persistence.PersistentCreateVoidMessageCommand;
import persistence.PersistentCreateVoidOperationCommand;
import persistence.PersistentDivCommand;
import persistence.PersistentFetchScalarCommand;
import persistence.PersistentFetchScalarTypeCommand;
import persistence.PersistentGetExistingCUTCommand;
import persistence.PersistentMulCommand;
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
import persistence.PersistentSubCommand;

public interface CommonDateExceptionVisitor<E extends UserException> {
    
    public void handleConvertToDefaultCommand(PersistentConvertToDefaultCommand convertToDefaultCommand) throws PersistenceException, E;
    public void handleCreateMObjectCommand(PersistentCreateMObjectCommand createMObjectCommand) throws PersistenceException, E;
    public void handleAddTypeCommand(PersistentAddTypeCommand addTypeCommand) throws PersistenceException, E;
    public void handleAssignTypeCommand(PersistentAssignTypeCommand assignTypeCommand) throws PersistenceException, E;
    public void handleCreateUnitTypeCommand(PersistentCreateUnitTypeCommand createUnitTypeCommand) throws PersistenceException, E;
    public void handleRemoveUnitTypeCommand(PersistentRemoveUnitTypeCommand removeUnitTypeCommand) throws PersistenceException, E;
    public void handleCreateAspectCommand(PersistentCreateAspectCommand createAspectCommand) throws PersistenceException, E;
    public void handleCreateUnitCommand(PersistentCreateUnitCommand createUnitCommand) throws PersistenceException, E;
    public void handleCreateTypeDisjunctionCommand(PersistentCreateTypeDisjunctionCommand createTypeDisjunctionCommand) throws PersistenceException, E;
    public void handleRemoveTypeCommand(PersistentRemoveTypeCommand removeTypeCommand) throws PersistenceException, E;
    public void handleRemoveAssoFrmHierCommand(PersistentRemoveAssoFrmHierCommand removeAssoFrmHierCommand) throws PersistenceException, E;
    public void handleSetConversionCommand(PersistentSetConversionCommand setConversionCommand) throws PersistenceException, E;
    public void handleCreateTypeConjunctionCommand(PersistentCreateTypeConjunctionCommand createTypeConjunctionCommand) throws PersistenceException, E;
    public void handleAssignNameCommand(PersistentAssignNameCommand assignNameCommand) throws PersistenceException, E;
    public void handleAggregateCommand(PersistentAggregateCommand aggregateCommand) throws PersistenceException, E;
    public void handleAddSubAccountTypeCommand(PersistentAddSubAccountTypeCommand addSubAccountTypeCommand) throws PersistenceException, E;
    public void handleRemoveLinkCommand(PersistentRemoveLinkCommand removeLinkCommand) throws PersistenceException, E;
    public void handleCreateHierarchyCommand(PersistentCreateHierarchyCommand createHierarchyCommand) throws PersistenceException, E;
    public void handleMulCommand(PersistentMulCommand mulCommand) throws PersistenceException, E;
    public void handleCreateMeasurementTypeCommand(PersistentCreateMeasurementTypeCommand createMeasurementTypeCommand) throws PersistenceException, E;
    public void handleCreateQuantityCommand(PersistentCreateQuantityCommand createQuantityCommand) throws PersistenceException, E;
    public void handleRemoveFpCommand(PersistentRemoveFpCommand removeFpCommand) throws PersistenceException, E;
    public void handleGetExistingCUTCommand(PersistentGetExistingCUTCommand getExistingCUTCommand) throws PersistenceException, E;
    public void handleFetchScalarCommand(PersistentFetchScalarCommand fetchScalarCommand) throws PersistenceException, E;
    public void handleRemoveOperationCommand(PersistentRemoveOperationCommand removeOperationCommand) throws PersistenceException, E;
    public void handleCreateConstantCommand(PersistentCreateConstantCommand createConstantCommand) throws PersistenceException, E;
    public void handleAddReferenceCommand(PersistentAddReferenceCommand addReferenceCommand) throws PersistenceException, E;
    public void handleCreateNameSchemeCommand(PersistentCreateNameSchemeCommand createNameSchemeCommand) throws PersistenceException, E;
    public void handleAddEntryCommand(PersistentAddEntryCommand addEntryCommand) throws PersistenceException, E;
    public void handleCreateMessageCommand(PersistentCreateMessageCommand createMessageCommand) throws PersistenceException, E;
    public void handleCreateAccountTypeCommand(PersistentCreateAccountTypeCommand createAccountTypeCommand) throws PersistenceException, E;
    public void handleDivCommand(PersistentDivCommand divCommand) throws PersistenceException, E;
    public void handleCreateStaticOpCommand(PersistentCreateStaticOpCommand createStaticOpCommand) throws PersistenceException, E;
    public void handleCreateAccountCommand(PersistentCreateAccountCommand createAccountCommand) throws PersistenceException, E;
    public void handleCreateAtomicSubTypeCommand(PersistentCreateAtomicSubTypeCommand createAtomicSubTypeCommand) throws PersistenceException, E;
    public void handleCreateLinkCommand(PersistentCreateLinkCommand createLinkCommand) throws PersistenceException, E;
    public void handleCreateVoidOperationCommand(PersistentCreateVoidOperationCommand createVoidOperationCommand) throws PersistenceException, E;
    public void handleSetDefaultUnitCommand(PersistentSetDefaultUnitCommand setDefaultUnitCommand) throws PersistenceException, E;
    public void handleChangeAbstractCommand(PersistentChangeAbstractCommand changeAbstractCommand) throws PersistenceException, E;
    public void handleRemoveAssociationCommand(PersistentRemoveAssociationCommand removeAssociationCommand) throws PersistenceException, E;
    public void handleAddFpCommand(PersistentAddFpCommand addFpCommand) throws PersistenceException, E;
    public void handleCreateStaticMessageCommand(PersistentCreateStaticMessageCommand createStaticMessageCommand) throws PersistenceException, E;
    public void handleSubCommand(PersistentSubCommand subCommand) throws PersistenceException, E;
    public void handleCreateVoidMessageCommand(PersistentCreateVoidMessageCommand createVoidMessageCommand) throws PersistenceException, E;
    public void handleAddAssociationCommand(PersistentAddAssociationCommand addAssociationCommand) throws PersistenceException, E;
    public void handleReplaceTypeCommand(PersistentReplaceTypeCommand replaceTypeCommand) throws PersistenceException, E;
    public void handleFetchScalarTypeCommand(PersistentFetchScalarTypeCommand fetchScalarTypeCommand) throws PersistenceException, E;
    public void handleCreateConstCommand(PersistentCreateConstCommand createConstCommand) throws PersistenceException, E;
    public void handleCreateOperationCommand(PersistentCreateOperationCommand createOperationCommand) throws PersistenceException, E;
    public void handleRemoveUnitCommand(PersistentRemoveUnitCommand removeUnitCommand) throws PersistenceException, E;
    public void handleAddMultipleFpCommand(PersistentAddMultipleFpCommand addMultipleFpCommand) throws PersistenceException, E;
    public void handleCreateAssociationCommand(PersistentCreateAssociationCommand createAssociationCommand) throws PersistenceException, E;
    public void handleCreateAtomicRootTypeCommand(PersistentCreateAtomicRootTypeCommand createAtomicRootTypeCommand) throws PersistenceException, E;
    public void handleAddCommand(PersistentAddCommand addCommand) throws PersistenceException, E;
    public void handleConvertCommand(PersistentConvertCommand convertCommand) throws PersistenceException, E;
    public void handleAddReferenceTypeCommand(PersistentAddReferenceTypeCommand addReferenceTypeCommand) throws PersistenceException, E;
    public void handleAddSubAccountCommand(PersistentAddSubAccountCommand addSubAccountCommand) throws PersistenceException, E;
    public void handleAddFractionCommand(PersistentAddFractionCommand addFractionCommand) throws PersistenceException, E;
    public void handleRemoveFpFromOpCommand(PersistentRemoveFpFromOpCommand removeFpFromOpCommand) throws PersistenceException, E;
    public void handleRemoveMessageCommand(PersistentRemoveMessageCommand removeMessageCommand) throws PersistenceException, E;
    public void handleCreateFpCommand(PersistentCreateFpCommand createFpCommand) throws PersistenceException, E;
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException, E;
    
}
