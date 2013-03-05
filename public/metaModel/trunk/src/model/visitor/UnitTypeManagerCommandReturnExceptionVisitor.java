
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentAddReferenceCommand;
import persistence.PersistentAddReferenceTypeCommand;
import persistence.PersistentCreateUnitCommand;
import persistence.PersistentCreateUnitTypeCommand;
import persistence.PersistentFetchScalarCommand;
import persistence.PersistentFetchScalarTypeCommand;
import persistence.PersistentGetExistingCUTCommand;
import persistence.PersistentRemoveUnitCommand;
import persistence.PersistentRemoveUnitTypeCommand;
import persistence.PersistentSetConversionCommand;
import persistence.PersistentSetDefaultUnitCommand;

public interface UnitTypeManagerCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleCreateUnitTypeCommand(PersistentCreateUnitTypeCommand createUnitTypeCommand) throws PersistenceException, E;
    public R handleRemoveUnitTypeCommand(PersistentRemoveUnitTypeCommand removeUnitTypeCommand) throws PersistenceException, E;
    public R handleCreateUnitCommand(PersistentCreateUnitCommand createUnitCommand) throws PersistenceException, E;
    public R handleSetConversionCommand(PersistentSetConversionCommand setConversionCommand) throws PersistenceException, E;
    public R handleGetExistingCUTCommand(PersistentGetExistingCUTCommand getExistingCUTCommand) throws PersistenceException, E;
    public R handleFetchScalarCommand(PersistentFetchScalarCommand fetchScalarCommand) throws PersistenceException, E;
    public R handleAddReferenceCommand(PersistentAddReferenceCommand addReferenceCommand) throws PersistenceException, E;
    public R handleSetDefaultUnitCommand(PersistentSetDefaultUnitCommand setDefaultUnitCommand) throws PersistenceException, E;
    public R handleFetchScalarTypeCommand(PersistentFetchScalarTypeCommand fetchScalarTypeCommand) throws PersistenceException, E;
    public R handleRemoveUnitCommand(PersistentRemoveUnitCommand removeUnitCommand) throws PersistenceException, E;
    public R handleAddReferenceTypeCommand(PersistentAddReferenceTypeCommand addReferenceTypeCommand) throws PersistenceException, E;
    
}
