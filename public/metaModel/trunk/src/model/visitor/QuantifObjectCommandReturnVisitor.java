
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentAggregateCommand;

public interface QuantifObjectCommandReturnVisitor<R> {
    
    public R handleAggregateCommand(PersistentAggregateCommand aggregateCommand) throws PersistenceException;
    
}
