
package model.visitor;
import model.UserException;
import persistence.*;

public interface EnumerationManagerCommandExceptionVisitor<E extends UserException> {
    
    public void handleCreateEnumCommand(PersistentCreateEnumCommand createEnumCommand) throws PersistenceException, E;
    public void handleDeleteEnumCommand(PersistentDeleteEnumCommand deleteEnumCommand) throws PersistenceException, E;
    public void handleCreateEnumValueCommand(PersistentCreateEnumValueCommand createEnumValueCommand) throws PersistenceException, E;
    public void handleDeleteEnumValueCommand(PersistentDeleteEnumValueCommand deleteEnumValueCommand) throws PersistenceException, E;
    
}
