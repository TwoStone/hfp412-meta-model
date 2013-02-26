
package model.visitor;
import model.UserException;
import persistence.*;

public interface MAccountTypeCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleAddSubAccountTypeCommand(PersistentAddSubAccountTypeCommand addSubAccountTypeCommand) throws PersistenceException, E;
    
}
