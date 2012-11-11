
package model.visitor;

import persistence.*;

public interface UnitManagerCommandVisitor {
    
    public void handleCreateUnitCommand(PersistentCreateUnitCommand createUnitCommand) throws PersistenceException;
    
}
