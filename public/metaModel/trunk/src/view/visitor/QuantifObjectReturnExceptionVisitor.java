
package view.visitor;
import view.UserException;
import view.*;

public interface QuantifObjectReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleMeasurement(MeasurementView measurement) throws ModelException, E;
    public R handleAccount(AccountView account) throws ModelException, E;
    
}
