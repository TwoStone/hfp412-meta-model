
package view.visitor;

import view.*;

public interface QuantifObjectReturnVisitor<R> {
    
    public R handleMeasurement(MeasurementView measurement) throws ModelException;
    public R handleAccount(AccountView account) throws ModelException;
    
}
