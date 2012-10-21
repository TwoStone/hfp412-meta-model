
package model.visitor;

import persistence.*;

public interface AnythingReturnVisitor<R> extends RolleReturnVisitor<R> ,CommonDateReturnVisitor<R> {
    
    public R handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException;
    public R handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException;
    public R handleCreateAkteurCommand(PersistentCreateAkteurCommand createAkteurCommand) throws PersistenceException;
    public R handleTransactionManager(PersistentTransactionManager transactionManager) throws PersistenceException;
    public R handleAddRoleCommand(PersistentAddRoleCommand addRoleCommand) throws PersistenceException;
    public R handleAuftrag(PersistentAuftrag auftrag) throws PersistenceException;
    public R handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public R handleServer(PersistentServer server) throws PersistenceException;
    public R handleAkteur(PersistentAkteur akteur) throws PersistenceException;
    public R handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    public R handlePosition(PersistentPosition position) throws PersistenceException;
    public R handleProdukt(PersistentProdukt produkt) throws PersistenceException;
    
}
