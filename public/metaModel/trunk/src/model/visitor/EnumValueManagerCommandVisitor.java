
package model.visitor;

import persistence.*;

public interface EnumValueManagerCommandVisitor {
    
    public void handleCreateEnumValueCommand(PersistentCreateEnumValueCommand createEnumValueCommand) throws PersistenceException;
    public void handleDeleteEnumValueCommand(PersistentDeleteEnumValueCommand deleteEnumValueCommand) throws PersistenceException;
    
}
