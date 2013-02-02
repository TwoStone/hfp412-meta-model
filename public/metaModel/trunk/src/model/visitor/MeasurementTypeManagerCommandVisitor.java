
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentCreateMeasurementTypeCommand;

public interface MeasurementTypeManagerCommandVisitor {
    
    public void handleCreateMeasurementTypeCommand(PersistentCreateMeasurementTypeCommand createMeasurementTypeCommand) throws PersistenceException;
    
}
