
package model.visitor;
import model.UserException;
import persistence.*;

public interface UnitManagerCommandExceptionVisitor<E extends UserException> {
    
    public void handleCreateUnitCommand(PersistentCreateUnitCommand createUnitCommand) throws PersistenceException, E;
    
}
