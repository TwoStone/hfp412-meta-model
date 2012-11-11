
package model.visitor;

import persistence.*;

public interface UnitManagerCommandReturnVisitor<R> {
    
    public R handleCreateUnitCommand(PersistentCreateUnitCommand createUnitCommand) throws PersistenceException;
    
}
