
package model.visitor;

import persistence.*;

public abstract class QuantifObjectStandardVisitor implements QuantifObjectVisitor {
    
    public void handleMeasurement(PersistentMeasurement measurement) throws PersistenceException{
        this.standardHandling(measurement);
    }
    public void handleAccount(PersistentAccount account) throws PersistenceException{
        this.standardHandling(account);
    }
    protected abstract void standardHandling(PersistentQuantifObject quantifObject) throws PersistenceException;
}
