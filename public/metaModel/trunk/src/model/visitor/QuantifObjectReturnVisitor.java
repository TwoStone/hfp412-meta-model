
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentAccount;
import persistence.PersistentMeasurement;

public interface QuantifObjectReturnVisitor<R> {
    
    public R handleMeasurement(PersistentMeasurement measurement) throws PersistenceException;
    public R handleAccount(PersistentAccount account) throws PersistenceException;
    
}
