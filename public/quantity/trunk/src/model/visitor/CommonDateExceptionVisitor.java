
package model.visitor;
import model.UserException;
import persistence.*;

public interface CommonDateExceptionVisitor<E extends UserException> {
    
    public void handleCreateUnitTypeCommand(PersistentCreateUnitTypeCommand createUnitTypeCommand) throws PersistenceException, E;
    public void handleCreateConversionCommand(PersistentCreateConversionCommand createConversionCommand) throws PersistenceException, E;
    public void handleCreateUnitCommand(PersistentCreateUnitCommand createUnitCommand) throws PersistenceException, E;
    public void handleCreateQuantityCommand(PersistentCreateQuantityCommand createQuantityCommand) throws PersistenceException, E;
    public void handleAddDefaultUnitCommand(PersistentAddDefaultUnitCommand addDefaultUnitCommand) throws PersistenceException, E;
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException, E;
    
}