
package model.visitor;

import persistence.*;

public abstract class MeasurementTypeManagerCommandStandardVisitor implements MeasurementTypeManagerCommandVisitor {
    
    public void handleCreateMeasurementTypeCommand(PersistentCreateMeasurementTypeCommand createMeasurementTypeCommand) throws PersistenceException{
        this.standardHandling(createMeasurementTypeCommand);
    }
    protected abstract void standardHandling(MeasurementTypeManagerCommand measurementTypeManagerCommand) throws PersistenceException;
}
