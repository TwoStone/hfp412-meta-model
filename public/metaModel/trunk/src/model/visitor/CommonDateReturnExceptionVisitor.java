
package model.visitor;
import model.UserException;
import persistence.*;

public interface CommonDateReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleAddAtomicTypeCommand(PersistentAddAtomicTypeCommand addAtomicTypeCommand) throws PersistenceException, E;
    public R handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException, E;
    
}
