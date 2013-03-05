
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentAddSubAccountTypeCommand;

public interface MAccountTypeCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleAddSubAccountTypeCommand(PersistentAddSubAccountTypeCommand addSubAccountTypeCommand) throws PersistenceException, E;
    
}
