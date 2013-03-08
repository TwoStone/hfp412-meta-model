
package model.visitor;

import persistence.*;

public abstract class EnumValueManagerCommandStandardVisitor implements EnumValueManagerCommandVisitor {
    
    public void handleCreateEnumValueCommand(PersistentCreateEnumValueCommand createEnumValueCommand) throws PersistenceException{
        this.standardHandling(createEnumValueCommand);
    }
    public void handleDeleteEnumValueCommand(PersistentDeleteEnumValueCommand deleteEnumValueCommand) throws PersistenceException{
        this.standardHandling(deleteEnumValueCommand);
    }
    protected abstract void standardHandling(EnumValueManagerCommand enumValueManagerCommand) throws PersistenceException;
}
