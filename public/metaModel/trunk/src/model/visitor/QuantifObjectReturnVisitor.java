
package model.visitor;

import persistence.*;

public interface QuantifObjectReturnVisitor<R> {
    
    public R handleMeasurement(PersistentMeasurement measurement) throws PersistenceException;
    public R handleAccount(PersistentAccount account) throws PersistenceException;
    
}
