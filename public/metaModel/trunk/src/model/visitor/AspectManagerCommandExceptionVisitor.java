
package model.visitor;
import model.UserException;
import persistence.*;

public interface AspectManagerCommandExceptionVisitor<E extends UserException> {
    
    public void handleAddAspectCommand(PersistentAddAspectCommand addAspectCommand) throws PersistenceException, E;
    
}
