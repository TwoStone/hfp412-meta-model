
package view.visitor;

import view.*;

public abstract class QuantifObjectStandardVisitor implements QuantifObjectVisitor {
    
    public void handleMeasurement(MeasurementView measurement) throws ModelException{
        this.standardHandling(measurement);
    }
    public void handleAccount(AccountView account) throws ModelException{
        this.standardHandling(account);
    }
    protected abstract void standardHandling(QuantifObjectView quantifObject) throws ModelException;
}
