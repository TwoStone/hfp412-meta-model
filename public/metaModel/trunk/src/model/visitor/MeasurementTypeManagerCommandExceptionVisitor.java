
package model.visitor;
import model.UserException;
import persistence.*;

public interface MeasurementTypeManagerCommandExceptionVisitor<E extends UserException> {
    
    public void handleCreateMeasurementTypeCommand(PersistentCreateMeasurementTypeCommand createMeasurementTypeCommand) throws PersistenceException, E;
    
}
