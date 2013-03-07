
package model.visitor;

import persistence.*;

public interface QuantifObjectCommandReturnVisitor<R> {
    
    public R handleAggregateCommand(PersistentAggregateCommand aggregateCommand) throws PersistenceException;
    
}
