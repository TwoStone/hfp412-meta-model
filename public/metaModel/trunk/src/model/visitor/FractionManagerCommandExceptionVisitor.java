
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentAddFractionCommand;

public interface FractionManagerCommandExceptionVisitor<E extends UserException> {
    
    public void handleAddFractionCommand(PersistentAddFractionCommand addFractionCommand) throws PersistenceException, E;
    
}
