
package model.visitor;

import persistence.*;

public abstract class FractionManagerCommandStandardVisitor implements FractionManagerCommandVisitor {
    
    public void handleAddFractionCommand(PersistentAddFractionCommand addFractionCommand) throws PersistenceException{
        this.standardHandling(addFractionCommand);
    }
    protected abstract void standardHandling(FractionManagerCommand fractionManagerCommand) throws PersistenceException;
}
