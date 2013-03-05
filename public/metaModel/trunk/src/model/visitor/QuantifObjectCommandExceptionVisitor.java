
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentAggregateCommand;

public interface QuantifObjectCommandExceptionVisitor<E extends UserException> {
    
    public void handleAggregateCommand(PersistentAggregateCommand aggregateCommand) throws PersistenceException, E;
    
}
