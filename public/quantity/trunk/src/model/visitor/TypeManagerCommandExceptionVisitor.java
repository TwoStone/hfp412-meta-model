
package model.visitor;
import model.UserException;
import persistence.*;

public interface TypeManagerCommandExceptionVisitor<E extends UserException> {
    
    public void handleCreateUnitTypeCommand(PersistentCreateUnitTypeCommand createUnitTypeCommand) throws PersistenceException, E;
    public void handleAddDefaultUnitCommand(PersistentAddDefaultUnitCommand addDefaultUnitCommand) throws PersistenceException, E;
    
}
