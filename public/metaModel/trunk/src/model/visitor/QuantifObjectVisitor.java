
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentAccount;
import persistence.PersistentMeasurement;

public interface QuantifObjectVisitor {
    
    public void handleMeasurement(PersistentMeasurement measurement) throws PersistenceException;
    public void handleAccount(PersistentAccount account) throws PersistenceException;
    
}
