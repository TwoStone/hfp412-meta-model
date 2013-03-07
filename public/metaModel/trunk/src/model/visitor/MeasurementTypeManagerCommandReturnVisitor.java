
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentCreateMeasurementTypeCommand;

public interface MeasurementTypeManagerCommandReturnVisitor<R> {
    
    public R handleCreateMeasurementTypeCommand(PersistentCreateMeasurementTypeCommand createMeasurementTypeCommand) throws PersistenceException;
    
}
