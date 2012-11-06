
package model.visitor;
import model.UserException;
import persistence.*;

public interface TypeManagerCommandExceptionVisitor<E extends UserException> {
    
    public void handleAddSubTypeCommand(PersistentAddSubTypeCommand addSubTypeCommand) throws PersistenceException, E;
    public void handleAddAtomicTypeCommand(PersistentAddAtomicTypeCommand addAtomicTypeCommand) throws PersistenceException, E;
    
}
