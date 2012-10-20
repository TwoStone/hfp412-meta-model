
package model.visitor;

import persistence.*;

public interface AkteurManagerCommandExceptionVisitor<E extends model.UserException> {
    
    public void handleCreateAkteurCommand(PersistentCreateAkteurCommand createAkteurCommand) throws PersistenceException, E;
    public void handleAddRoleCommand(PersistentAddRoleCommand addRoleCommand) throws PersistenceException, E;
    
}
