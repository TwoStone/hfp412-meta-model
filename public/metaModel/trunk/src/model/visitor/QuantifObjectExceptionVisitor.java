
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentAccount;
import persistence.PersistentMeasurement;

public interface QuantifObjectExceptionVisitor<E extends UserException> {
    
    public void handleMeasurement(PersistentMeasurement measurement) throws PersistenceException, E;
    public void handleAccount(PersistentAccount account) throws PersistenceException, E;
    
}
