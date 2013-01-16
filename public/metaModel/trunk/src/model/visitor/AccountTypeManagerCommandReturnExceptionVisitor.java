
package model.visitor;
import model.UserException;
import persistence.*;

public interface AccountTypeManagerCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleCreateAccountTypeCommand(PersistentCreateAccountTypeCommand createAccountTypeCommand) throws PersistenceException, E;
    
}
