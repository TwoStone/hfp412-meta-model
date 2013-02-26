
package model.visitor;
import model.UserException;
import persistence.*;

public interface MAccountTypeCommandExceptionVisitor<E extends UserException> {
    
    public void handleAddSubAccountTypeCommand(PersistentAddSubAccountTypeCommand addSubAccountTypeCommand) throws PersistenceException, E;
    
}
