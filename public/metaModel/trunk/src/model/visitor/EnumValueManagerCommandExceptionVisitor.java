
package model.visitor;
import model.UserException;
import persistence.*;

public interface EnumValueManagerCommandExceptionVisitor<E extends UserException> {
    
    public void handleCreateEnumValueCommand(PersistentCreateEnumValueCommand createEnumValueCommand) throws PersistenceException, E;
    public void handleDeleteEnumValueCommand(PersistentDeleteEnumValueCommand deleteEnumValueCommand) throws PersistenceException, E;
    
}
