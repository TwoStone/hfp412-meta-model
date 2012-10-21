
package model.visitor;

import persistence.*;

public abstract class TransactionManagerCommandStandardVisitor implements TransactionManagerCommandVisitor {
    
    public void handleCreateAkteurCommand(PersistentCreateAkteurCommand createAkteurCommand) throws PersistenceException{
        this.standardHandling(createAkteurCommand);
    }
    public void handleAddRoleCommand(PersistentAddRoleCommand addRoleCommand) throws PersistenceException{
        this.standardHandling(addRoleCommand);
    }
    protected abstract void standardHandling(TransactionManagerCommand transactionManagerCommand) throws PersistenceException;
}
