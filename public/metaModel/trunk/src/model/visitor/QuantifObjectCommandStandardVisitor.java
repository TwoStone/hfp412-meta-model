
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentAggregateCommand;
import persistence.QuantifObjectCommand;

public abstract class QuantifObjectCommandStandardVisitor implements QuantifObjectCommandVisitor {
    
    public void handleAggregateCommand(PersistentAggregateCommand aggregateCommand) throws PersistenceException{
        this.standardHandling(aggregateCommand);
    }
    protected abstract void standardHandling(QuantifObjectCommand quantifObjectCommand) throws PersistenceException;
}
