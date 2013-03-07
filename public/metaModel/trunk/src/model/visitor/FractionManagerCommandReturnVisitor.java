
package model.visitor;

import persistence.*;

public interface FractionManagerCommandReturnVisitor<R> {
    
    public R handleAddFractionCommand(PersistentAddFractionCommand addFractionCommand) throws PersistenceException;
    
}
