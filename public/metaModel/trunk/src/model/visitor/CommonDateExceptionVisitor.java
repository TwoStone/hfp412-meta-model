
package model.visitor;
import model.UserException;
import persistence.*;

public interface CommonDateExceptionVisitor<E extends UserException> {
    
    public void handleAddAspectCommand(PersistentAddAspectCommand addAspectCommand) throws PersistenceException, E;
    public void handleAddSubTypeCommand(PersistentAddSubTypeCommand addSubTypeCommand) throws PersistenceException, E;
    public void handleAddAtomicTypeCommand(PersistentAddAtomicTypeCommand addAtomicTypeCommand) throws PersistenceException, E;
    public void handleCreateSubTypeCommand(PersistentCreateSubTypeCommand createSubTypeCommand) throws PersistenceException, E;
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException, E;
    
}
