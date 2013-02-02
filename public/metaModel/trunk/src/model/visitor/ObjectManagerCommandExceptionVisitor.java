
package model.visitor;
import model.UserException;
import persistence.*;

public interface ObjectManagerCommandExceptionVisitor<E extends UserException> {
    
    public void handleAddTypeCommand(PersistentAddTypeCommand addTypeCommand) throws PersistenceException, E;
    public void handleCreateMObjectCommand(PersistentCreateMObjectCommand createMObjectCommand) throws PersistenceException, E;
    public void handleRemoveTypeCommand(PersistentRemoveTypeCommand removeTypeCommand) throws PersistenceException, E;
    public void handleReplaceTypeCommand(PersistentReplaceTypeCommand replaceTypeCommand) throws PersistenceException, E;
    
}
