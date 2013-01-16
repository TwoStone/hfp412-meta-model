
package view.visitor;
import view.UserException;
import view.*;

public interface QuantifObjectExceptionVisitor<E extends UserException> {
    
    public void handleMeasurement(MeasurementView measurement) throws ModelException, E;
    public void handleAccount(AccountView account) throws ModelException, E;
    
}
