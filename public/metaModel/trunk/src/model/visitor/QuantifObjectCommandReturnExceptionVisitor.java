
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentAggregateCommand;

public interface QuantifObjectCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleAggregateCommand(PersistentAggregateCommand aggregateCommand) throws PersistenceException, E;
    
}
