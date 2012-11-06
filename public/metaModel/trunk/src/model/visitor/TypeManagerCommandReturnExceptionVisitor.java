
package model.visitor;
import model.UserException;
import persistence.*;

public interface TypeManagerCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleAddSubTypeCommand(PersistentAddSubTypeCommand addSubTypeCommand) throws PersistenceException, E;
    public R handleAddAtomicTypeCommand(PersistentAddAtomicTypeCommand addAtomicTypeCommand) throws PersistenceException, E;
    public R handleCreateSubTypeCommand(PersistentCreateSubTypeCommand createSubTypeCommand) throws PersistenceException, E;
    
}
