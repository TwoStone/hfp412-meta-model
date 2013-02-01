
package model.visitor;

import persistence.*;

public interface MeasurementTypeManagerCommandVisitor {
    
    public void handleCreateMeasurementTypeCommand(PersistentCreateMeasurementTypeCommand createMeasurementTypeCommand) throws PersistenceException;
    
}
