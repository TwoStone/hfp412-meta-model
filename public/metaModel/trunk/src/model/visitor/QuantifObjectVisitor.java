
package model.visitor;

import persistence.*;

public interface QuantifObjectVisitor {
    
    public void handleMeasurement(PersistentMeasurement measurement) throws PersistenceException;
    public void handleAccount(PersistentAccount account) throws PersistenceException;
    
}
