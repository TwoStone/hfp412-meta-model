
package model.visitor;
import model.UserException;
import persistence.*;

public interface MeasurementTypeManagerCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleCreateMeasurementTypeCommand(PersistentCreateMeasurementTypeCommand createMeasurementTypeCommand) throws PersistenceException, E;
    
}
