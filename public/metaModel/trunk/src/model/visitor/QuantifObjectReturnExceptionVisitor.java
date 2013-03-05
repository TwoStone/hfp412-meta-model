
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentAccount;
import persistence.PersistentMeasurement;

public interface QuantifObjectReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleMeasurement(PersistentMeasurement measurement) throws PersistenceException, E;
    public R handleAccount(PersistentAccount account) throws PersistenceException, E;
    
}
