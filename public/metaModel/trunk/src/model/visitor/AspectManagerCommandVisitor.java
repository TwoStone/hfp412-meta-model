
package model.visitor;

import persistence.*;

public interface AspectManagerCommandVisitor {
    
    public void handleAddAspectCommand(PersistentAddAspectCommand addAspectCommand) throws PersistenceException;
    
}
