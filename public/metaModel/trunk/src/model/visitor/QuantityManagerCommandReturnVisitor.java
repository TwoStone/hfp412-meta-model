
package model.visitor;

import persistence.*;

public interface QuantityManagerCommandReturnVisitor<R> {
    
    public R handleConvertToDefaultCommand(PersistentConvertToDefaultCommand convertToDefaultCommand) throws PersistenceException;
    public R handleCreateQuantityCommand(PersistentCreateQuantityCommand createQuantityCommand) throws PersistenceException;
    public R handleConvertCommand(PersistentConvertCommand convertCommand) throws PersistenceException;
    
}
