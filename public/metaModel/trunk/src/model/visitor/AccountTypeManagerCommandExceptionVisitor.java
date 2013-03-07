
package model.visitor;
import model.UserException;
import persistence.*;

public interface AccountTypeManagerCommandExceptionVisitor<E extends UserException> {
    
    public void handleCreateAccountTypeCommand(PersistentCreateAccountTypeCommand createAccountTypeCommand) throws PersistenceException, E;
    
}
