
package model.visitor;
import model.UserException;
import persistence.*;

public interface AccountCommandExceptionVisitor<E extends UserException> {
    
    public void handleAddEntryCommand(PersistentAddEntryCommand addEntryCommand) throws PersistenceException, E;
    public void handleAddSubAccountCommand(PersistentAddSubAccountCommand addSubAccountCommand) throws PersistenceException, E;
    
}
