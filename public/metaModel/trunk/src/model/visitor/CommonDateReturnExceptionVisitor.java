
package model.visitor;
import model.UserException;
import persistence.*;

public interface CommonDateReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleAddAspectCommand(PersistentAddAspectCommand addAspectCommand) throws PersistenceException, E;
    public R handleAddSubTypeCommand(PersistentAddSubTypeCommand addSubTypeCommand) throws PersistenceException, E;
    public R handleAddAtomicTypeCommand(PersistentAddAtomicTypeCommand addAtomicTypeCommand) throws PersistenceException, E;
    public R handleCreateSubTypeCommand(PersistentCreateSubTypeCommand createSubTypeCommand) throws PersistenceException, E;
    public R handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException, E;
    
}
