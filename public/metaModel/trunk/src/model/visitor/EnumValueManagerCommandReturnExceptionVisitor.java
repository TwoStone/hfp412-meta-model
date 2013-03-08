
package model.visitor;
import model.UserException;
import persistence.*;

public interface EnumValueManagerCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleCreateEnumValueCommand(PersistentCreateEnumValueCommand createEnumValueCommand) throws PersistenceException, E;
    public R handleDeleteEnumValueCommand(PersistentDeleteEnumValueCommand deleteEnumValueCommand) throws PersistenceException, E;
    
}
