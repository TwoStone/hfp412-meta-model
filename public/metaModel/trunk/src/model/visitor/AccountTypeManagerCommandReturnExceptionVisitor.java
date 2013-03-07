
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentCreateAccountTypeCommand;

public interface AccountTypeManagerCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleCreateAccountTypeCommand(PersistentCreateAccountTypeCommand createAccountTypeCommand) throws PersistenceException, E;
    
}
