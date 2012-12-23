
package model.visitor;

import persistence.*;

public abstract class ConversionManagerCommandStandardVisitor implements ConversionManagerCommandVisitor {
    
    public void handleCreateConversionCommand(PersistentCreateConversionCommand createConversionCommand) throws PersistenceException{
        this.standardHandling(createConversionCommand);
    }
    protected abstract void standardHandling(ConversionManagerCommand conversionManagerCommand) throws PersistenceException;
}
