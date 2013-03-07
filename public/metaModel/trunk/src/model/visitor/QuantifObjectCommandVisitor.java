
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentAggregateCommand;

public interface QuantifObjectCommandVisitor {
    
    public void handleAggregateCommand(PersistentAggregateCommand aggregateCommand) throws PersistenceException;
    
}
