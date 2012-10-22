
package model.visitor;

import persistence.*;

public interface TransactionManagerCommandReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleCreateAkteurCommand(PersistentCreateAkteurCommand createAkteurCommand) throws PersistenceException, E;
    public R handleAddRoleCommand(PersistentAddRoleCommand addRoleCommand) throws PersistenceException, E;
    
}
