
package model.visitor;

import persistence.*;

public interface TransactionManagerCommandVisitor {
    
    public void handleCreateAkteurCommand(PersistentCreateAkteurCommand createAkteurCommand) throws PersistenceException;
    public void handleAddRoleCommand(PersistentAddRoleCommand addRoleCommand) throws PersistenceException;
    
}
