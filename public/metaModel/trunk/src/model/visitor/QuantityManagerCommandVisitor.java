
package model.visitor;

import persistence.*;

public interface QuantityManagerCommandVisitor {
    
    public void handleConvertToDefaultCommand(PersistentConvertToDefaultCommand convertToDefaultCommand) throws PersistenceException;
    public void handleCreateQuantityCommand(PersistentCreateQuantityCommand createQuantityCommand) throws PersistenceException;
    public void handleConvertCommand(PersistentConvertCommand convertCommand) throws PersistenceException;
    
}
