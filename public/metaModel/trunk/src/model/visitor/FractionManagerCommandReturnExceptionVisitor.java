
package model.visitor;
import model.UserException;
import persistence.*;

public interface FractionManagerCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleAddFractionCommand(PersistentAddFractionCommand addFractionCommand) throws PersistenceException, E;
    
}
