
package model.visitor;
import model.UserException;
import persistence.*;

public interface UnitTypeManagerCommandExceptionVisitor<E extends UserException> {
    
    public void handleCreateUnitTypeCommand(PersistentCreateUnitTypeCommand createUnitTypeCommand) throws PersistenceException, E;
    public void handleCreateUnitCommand(PersistentCreateUnitCommand createUnitCommand) throws PersistenceException, E;
    public void handleCreateCompUnitCommand(PersistentCreateCompUnitCommand createCompUnitCommand) throws PersistenceException, E;
    public void handleCreateCompUnitTypeCommand(PersistentCreateCompUnitTypeCommand createCompUnitTypeCommand) throws PersistenceException, E;
    public void handleAddDefaultUnitCommand(PersistentAddDefaultUnitCommand addDefaultUnitCommand) throws PersistenceException, E;
    public void handleFinishModelingCommand(PersistentFinishModelingCommand finishModelingCommand) throws PersistenceException, E;
    public void handleAddReferenceTypeCommand(PersistentAddReferenceTypeCommand addReferenceTypeCommand) throws PersistenceException, E;
    
}
