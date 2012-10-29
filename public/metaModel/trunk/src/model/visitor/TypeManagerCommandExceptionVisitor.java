
package model.visitor;
import model.UserException;
import persistence.*;

public interface TypeManagerCommandExceptionVisitor<E extends UserException> {
    
    public void handleAddAtomicTypeCommand(PersistentAddAtomicTypeCommand addAtomicTypeCommand) throws PersistenceException, E;
    
}
