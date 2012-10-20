
package model.visitor;

import persistence.*;

public interface CommonDateVisitor {
    
    public void handleCreateAkteurCommand(PersistentCreateAkteurCommand createAkteurCommand) throws PersistenceException;
    public void handleAddRoleCommand(PersistentAddRoleCommand addRoleCommand) throws PersistenceException;
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    
}
