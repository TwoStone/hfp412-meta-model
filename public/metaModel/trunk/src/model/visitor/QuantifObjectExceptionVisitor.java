
package model.visitor;
import model.UserException;
import persistence.*;

public interface QuantifObjectExceptionVisitor<E extends UserException> {
    
    public void handleMeasurement(PersistentMeasurement measurement) throws PersistenceException, E;
    public void handleAccount(PersistentAccount account) throws PersistenceException, E;
    
}
