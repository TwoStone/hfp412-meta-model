
package model.visitor;

import persistence.*;

public interface TransactionManagerCommandReturnVisitor<R> {
    
    public R handleCreateAkteurCommand(PersistentCreateAkteurCommand createAkteurCommand) throws PersistenceException;
    public R handleAddRoleCommand(PersistentAddRoleCommand addRoleCommand) throws PersistenceException;
    
}