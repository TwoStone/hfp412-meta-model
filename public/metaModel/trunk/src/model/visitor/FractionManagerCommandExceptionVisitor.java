
package model.visitor;
import model.UserException;
import persistence.*;

public interface FractionManagerCommandExceptionVisitor<E extends UserException> {
    
    public void handleAddFractionCommand(PersistentAddFractionCommand addFractionCommand) throws PersistenceException, E;
    
}
