
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentAddFractionCommand;

public interface FractionManagerCommandVisitor {
    
    public void handleAddFractionCommand(PersistentAddFractionCommand addFractionCommand) throws PersistenceException;
    
}
