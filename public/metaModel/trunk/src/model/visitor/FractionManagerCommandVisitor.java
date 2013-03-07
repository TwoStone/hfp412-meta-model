
package model.visitor;

import persistence.*;

public interface FractionManagerCommandVisitor {
    
    public void handleAddFractionCommand(PersistentAddFractionCommand addFractionCommand) throws PersistenceException;
    
}
