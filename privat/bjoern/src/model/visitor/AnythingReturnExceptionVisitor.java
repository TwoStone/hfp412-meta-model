
package model.visitor;

import persistence.*;

public interface AnythingReturnExceptionVisitor<R, E extends model.UserException> extends RolleReturnExceptionVisitor<R, E> ,CommonDateReturnExceptionVisitor<R, E> {
    
    public R handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException, E;
    public R handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException, E;
    public R handleCreateAkteurCommand(PersistentCreateAkteurCommand createAkteurCommand) throws PersistenceException, E;
    public R handleTransactionManager(PersistentTransactionManager transactionManager) throws PersistenceException, E;
    public R handleAddRoleCommand(PersistentAddRoleCommand addRoleCommand) throws PersistenceException, E;
    public R handleAuftrag(PersistentAuftrag auftrag) throws PersistenceException, E;
    public R handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException, E;
    public R handleServer(PersistentServer server) throws PersistenceException, E;
    public R handleAkteur(PersistentAkteur akteur) throws PersistenceException, E;
    public R handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException, E;
    public R handlePosition(PersistentPosition position) throws PersistenceException, E;
    public R handleProdukt(PersistentProdukt produkt) throws PersistenceException, E;
    
}
