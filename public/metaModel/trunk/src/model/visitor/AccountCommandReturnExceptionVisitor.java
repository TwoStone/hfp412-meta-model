
package model.visitor;
import model.UserException;
import persistence.*;

public interface AccountCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleAddEntryCommand(PersistentAddEntryCommand addEntryCommand) throws PersistenceException, E;
    public R handleAddSubAccountCommand(PersistentAddSubAccountCommand addSubAccountCommand) throws PersistenceException, E;
    
}
