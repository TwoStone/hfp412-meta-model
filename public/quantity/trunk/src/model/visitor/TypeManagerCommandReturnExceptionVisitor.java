
package model.visitor;
import model.UserException;
import persistence.*;

public interface TypeManagerCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleCreateUnitTypeCommand(PersistentCreateUnitTypeCommand createUnitTypeCommand) throws PersistenceException, E;
    public R handleAddDefaultUnitCommand(PersistentAddDefaultUnitCommand addDefaultUnitCommand) throws PersistenceException, E;
    
}
