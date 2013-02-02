
package model.visitor;

import persistence.*;

public interface MeasurementTypeManagerCommandReturnVisitor<R> {
    
    public R handleCreateMeasurementTypeCommand(PersistentCreateMeasurementTypeCommand createMeasurementTypeCommand) throws PersistenceException;
    
}
