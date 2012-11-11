
package model.visitor;
import model.UserException;
import persistence.*;

public interface UnitManagerCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleCreateUnitCommand(PersistentCreateUnitCommand createUnitCommand) throws PersistenceException, E;
    
}
