
package model.visitor;
import model.UserException;
import persistence.*;

public interface TypeManagerCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleAddAtomicTypeCommand(PersistentAddAtomicTypeCommand addAtomicTypeCommand) throws PersistenceException, E;
    
}
