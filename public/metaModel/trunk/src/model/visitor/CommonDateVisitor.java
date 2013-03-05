
package model.visitor;

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

public interface CommonDateVisitor {
    
    public void handleConvertToDefaultCommand(PersistentConvertToDefaultCommand convertToDefaultCommand) throws PersistenceException;
    public void handleCreateMObjectCommand(PersistentCreateMObjectCommand createMObjectCommand) throws PersistenceException;
    public void handleAddTypeCommand(PersistentAddTypeCommand addTypeCommand) throws PersistenceException;
    public void handleAssignTypeCommand(PersistentAssignTypeCommand assignTypeCommand) throws PersistenceException;
    public void handleCreateUnitTypeCommand(PersistentCreateUnitTypeCommand createUnitTypeCommand) throws PersistenceException;
    public void handleRemoveUnitTypeCommand(PersistentRemoveUnitTypeCommand removeUnitTypeCommand) throws PersistenceException;
    public void handleCreateAspectCommand(PersistentCreateAspectCommand createAspectCommand) throws PersistenceException;
    public void handleCreateUnitCommand(PersistentCreateUnitCommand createUnitCommand) throws PersistenceException;
    public void handleCreateTypeDisjunctionCommand(PersistentCreateTypeDisjunctionCommand createTypeDisjunctionCommand) throws PersistenceException;
    public void handleRemoveTypeCommand(PersistentRemoveTypeCommand removeTypeCommand) throws PersistenceException;
    public void handleRemoveAssoFrmHierCommand(PersistentRemoveAssoFrmHierCommand removeAssoFrmHierCommand) throws PersistenceException;
    public void handleSetConversionCommand(PersistentSetConversionCommand setConversionCommand) throws PersistenceException;
    public void handleCreateTypeConjunctionCommand(PersistentCreateTypeConjunctionCommand createTypeConjunctionCommand) throws PersistenceException;
    public void handleAssignNameCommand(PersistentAssignNameCommand assignNameCommand) throws PersistenceException;
    public void handleAggregateCommand(PersistentAggregateCommand aggregateCommand) throws PersistenceException;
    public void handleAddSubAccountTypeCommand(PersistentAddSubAccountTypeCommand addSubAccountTypeCommand) throws PersistenceException;
    public void handleRemoveLinkCommand(PersistentRemoveLinkCommand removeLinkCommand) throws PersistenceException;
    public void handleCreateHierarchyCommand(PersistentCreateHierarchyCommand createHierarchyCommand) throws PersistenceException;
    public void handleMulCommand(PersistentMulCommand mulCommand) throws PersistenceException;
    public void handleCreateMeasurementTypeCommand(PersistentCreateMeasurementTypeCommand createMeasurementTypeCommand) throws PersistenceException;
    public void handleCreateQuantityCommand(PersistentCreateQuantityCommand createQuantityCommand) throws PersistenceException;
    public void handleRemoveFpCommand(PersistentRemoveFpCommand removeFpCommand) throws PersistenceException;
    public void handleGetExistingCUTCommand(PersistentGetExistingCUTCommand getExistingCUTCommand) throws PersistenceException;
    public void handleFetchScalarCommand(PersistentFetchScalarCommand fetchScalarCommand) throws PersistenceException;
    public void handleRemoveOperationCommand(PersistentRemoveOperationCommand removeOperationCommand) throws PersistenceException;
    public void handleCreateConstantCommand(PersistentCreateConstantCommand createConstantCommand) throws PersistenceException;
    public void handleAddReferenceCommand(PersistentAddReferenceCommand addReferenceCommand) throws PersistenceException;
    public void handleCreateNameSchemeCommand(PersistentCreateNameSchemeCommand createNameSchemeCommand) throws PersistenceException;
    public void handleAddEntryCommand(PersistentAddEntryCommand addEntryCommand) throws PersistenceException;
    public void handleCreateMessageCommand(PersistentCreateMessageCommand createMessageCommand) throws PersistenceException;
    public void handleCreateAccountTypeCommand(PersistentCreateAccountTypeCommand createAccountTypeCommand) throws PersistenceException;
    public void handleDivCommand(PersistentDivCommand divCommand) throws PersistenceException;
    public void handleCreateStaticOpCommand(PersistentCreateStaticOpCommand createStaticOpCommand) throws PersistenceException;
    public void handleCreateAccountCommand(PersistentCreateAccountCommand createAccountCommand) throws PersistenceException;
    public void handleCreateAtomicSubTypeCommand(PersistentCreateAtomicSubTypeCommand createAtomicSubTypeCommand) throws PersistenceException;
    public void handleCreateLinkCommand(PersistentCreateLinkCommand createLinkCommand) throws PersistenceException;
    public void handleCreateVoidOperationCommand(PersistentCreateVoidOperationCommand createVoidOperationCommand) throws PersistenceException;
    public void handleSetDefaultUnitCommand(PersistentSetDefaultUnitCommand setDefaultUnitCommand) throws PersistenceException;
    public void handleChangeAbstractCommand(PersistentChangeAbstractCommand changeAbstractCommand) throws PersistenceException;
    public void handleRemoveAssociationCommand(PersistentRemoveAssociationCommand removeAssociationCommand) throws PersistenceException;
    public void handleAddFpCommand(PersistentAddFpCommand addFpCommand) throws PersistenceException;
    public void handleCreateStaticMessageCommand(PersistentCreateStaticMessageCommand createStaticMessageCommand) throws PersistenceException;
    public void handleSubCommand(PersistentSubCommand subCommand) throws PersistenceException;
    public void handleCreateVoidMessageCommand(PersistentCreateVoidMessageCommand createVoidMessageCommand) throws PersistenceException;
    public void handleAddAssociationCommand(PersistentAddAssociationCommand addAssociationCommand) throws PersistenceException;
    public void handleReplaceTypeCommand(PersistentReplaceTypeCommand replaceTypeCommand) throws PersistenceException;
    public void handleFetchScalarTypeCommand(PersistentFetchScalarTypeCommand fetchScalarTypeCommand) throws PersistenceException;
    public void handleCreateConstCommand(PersistentCreateConstCommand createConstCommand) throws PersistenceException;
    public void handleCreateOperationCommand(PersistentCreateOperationCommand createOperationCommand) throws PersistenceException;
    public void handleRemoveUnitCommand(PersistentRemoveUnitCommand removeUnitCommand) throws PersistenceException;
    public void handleAddMultipleFpCommand(PersistentAddMultipleFpCommand addMultipleFpCommand) throws PersistenceException;
    public void handleCreateAssociationCommand(PersistentCreateAssociationCommand createAssociationCommand) throws PersistenceException;
    public void handleCreateAtomicRootTypeCommand(PersistentCreateAtomicRootTypeCommand createAtomicRootTypeCommand) throws PersistenceException;
    public void handleAddCommand(PersistentAddCommand addCommand) throws PersistenceException;
    public void handleConvertCommand(PersistentConvertCommand convertCommand) throws PersistenceException;
    public void handleAddReferenceTypeCommand(PersistentAddReferenceTypeCommand addReferenceTypeCommand) throws PersistenceException;
    public void handleAddSubAccountCommand(PersistentAddSubAccountCommand addSubAccountCommand) throws PersistenceException;
    public void handleAddFractionCommand(PersistentAddFractionCommand addFractionCommand) throws PersistenceException;
    public void handleRemoveFpFromOpCommand(PersistentRemoveFpFromOpCommand removeFpFromOpCommand) throws PersistenceException;
    public void handleRemoveMessageCommand(PersistentRemoveMessageCommand removeMessageCommand) throws PersistenceException;
    public void handleCreateFpCommand(PersistentCreateFpCommand createFpCommand) throws PersistenceException;
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    
}
