
package model.visitor;

import persistence.*;

public interface QuantifObjectCommandVisitor {
    
    public void handleAggregateCommand(PersistentAggregateCommand aggregateCommand) throws PersistenceException;
    
}
