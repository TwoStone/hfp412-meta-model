
package model.visitor;

import persistence.*;

public interface TypeManagerCommandReturnVisitor<R> {
    
    public R handleCreateUnitTypeCommand(PersistentCreateUnitTypeCommand createUnitTypeCommand) throws PersistenceException;
    public R handleAddDefaultUnitCommand(PersistentAddDefaultUnitCommand addDefaultUnitCommand) throws PersistenceException;
    
}
