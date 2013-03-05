
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentAddFractionCommand;

public interface FractionManagerCommandReturnVisitor<R> {
    
    public R handleAddFractionCommand(PersistentAddFractionCommand addFractionCommand) throws PersistenceException;
    
}
