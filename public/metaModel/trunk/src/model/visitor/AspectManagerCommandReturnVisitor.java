
package model.visitor;

import persistence.*;

public interface AspectManagerCommandReturnVisitor<R> {
    
    public R handleAddAspectCommand(PersistentAddAspectCommand addAspectCommand) throws PersistenceException;
    
}
