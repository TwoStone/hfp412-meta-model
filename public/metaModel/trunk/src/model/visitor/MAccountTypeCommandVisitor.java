
package model.visitor;

import persistence.*;

public interface MAccountTypeCommandVisitor {
    
    public void handleAddSubAccountTypeCommand(PersistentAddSubAccountTypeCommand addSubAccountTypeCommand) throws PersistenceException;
    
}
