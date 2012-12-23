
package model.visitor;

import persistence.*;

public interface ConversionManagerCommandVisitor {
    
    public void handleCreateConversionCommand(PersistentCreateConversionCommand createConversionCommand) throws PersistenceException;
    
}
