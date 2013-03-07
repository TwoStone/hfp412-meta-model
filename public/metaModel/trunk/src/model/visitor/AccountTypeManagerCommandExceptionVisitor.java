
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentCreateAccountTypeCommand;

public interface AccountTypeManagerCommandExceptionVisitor<E extends UserException> {
    
    public void handleCreateAccountTypeCommand(PersistentCreateAccountTypeCommand createAccountTypeCommand) throws PersistenceException, E;
    
}
