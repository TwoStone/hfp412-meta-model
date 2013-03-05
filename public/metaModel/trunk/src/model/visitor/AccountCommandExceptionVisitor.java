
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentAddEntryCommand;
import persistence.PersistentAddSubAccountCommand;

public interface AccountCommandExceptionVisitor<E extends UserException> {
    
    public void handleAddEntryCommand(PersistentAddEntryCommand addEntryCommand) throws PersistenceException, E;
    public void handleAddSubAccountCommand(PersistentAddSubAccountCommand addSubAccountCommand) throws PersistenceException, E;
    
}
