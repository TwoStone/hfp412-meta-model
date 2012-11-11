
package model.visitor;

import persistence.*;

public interface ConversionManagerCommandReturnVisitor<R> {
    
    public R handleCreateConversionCommand(PersistentCreateConversionCommand createConversionCommand) throws PersistenceException;
    
}
