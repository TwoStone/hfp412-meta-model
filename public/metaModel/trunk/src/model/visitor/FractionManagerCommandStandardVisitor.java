
package model.visitor;

import persistence.FractionManagerCommand;
import persistence.PersistenceException;
import persistence.PersistentAddFractionCommand;

public abstract class FractionManagerCommandStandardVisitor implements FractionManagerCommandVisitor {
    
    public void handleAddFractionCommand(PersistentAddFractionCommand addFractionCommand) throws PersistenceException{
        this.standardHandling(addFractionCommand);
    }
    protected abstract void standardHandling(FractionManagerCommand fractionManagerCommand) throws PersistenceException;
}
