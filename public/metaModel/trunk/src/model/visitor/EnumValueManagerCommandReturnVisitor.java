
package model.visitor;

import persistence.*;

public interface EnumValueManagerCommandReturnVisitor<R> {
    
    public R handleCreateEnumValueCommand(PersistentCreateEnumValueCommand createEnumValueCommand) throws PersistenceException;
    public R handleDeleteEnumValueCommand(PersistentDeleteEnumValueCommand deleteEnumValueCommand) throws PersistenceException;
    
}
