
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentAddTypeCommand;
import persistence.PersistentCreateMObjectCommand;
import persistence.PersistentRemoveTypeCommand;
import persistence.PersistentReplaceTypeCommand;

public interface ObjectManagerCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleCreateMObjectCommand(PersistentCreateMObjectCommand createMObjectCommand) throws PersistenceException, E;
    public R handleAddTypeCommand(PersistentAddTypeCommand addTypeCommand) throws PersistenceException, E;
    public R handleRemoveTypeCommand(PersistentRemoveTypeCommand removeTypeCommand) throws PersistenceException, E;
    public R handleReplaceTypeCommand(PersistentReplaceTypeCommand replaceTypeCommand) throws PersistenceException, E;
    
}
