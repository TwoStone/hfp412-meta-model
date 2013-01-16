
package view.visitor;

import view.*;

public interface QuantifObjectVisitor {
    
    public void handleMeasurement(MeasurementView measurement) throws ModelException;
    public void handleAccount(AccountView account) throws ModelException;
    
}
