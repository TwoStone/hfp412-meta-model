
package model.visitor;
import model.UserException;
import persistence.*;

public interface QuantifObjectCommandExceptionVisitor<E extends UserException> {
    
    public void handleAggregateCommand(PersistentAggregateCommand aggregateCommand) throws PersistenceException, E;
    
}
