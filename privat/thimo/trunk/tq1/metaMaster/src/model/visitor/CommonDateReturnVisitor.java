
package model.visitor;

import persistence.*;

public interface CommonDateReturnVisitor<R> {
    
    public R handleAddRoleCommand(PersistentAddRoleCommand addRoleCommand) throws PersistenceException;
    public R handleCreateActorCommand(PersistentCreateActorCommand createActorCommand) throws PersistenceException;
    public R handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    
}
