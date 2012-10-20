
package model.visitor;

import persistence.*;

public interface AnythingExceptionVisitor<E extends model.UserException> extends CommonDateExceptionVisitor<E>,RolleExceptionVisitor<E>{
    
    public void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException, E;
    public void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException, E;
    public void handleCreateAkteurCommand(PersistentCreateAkteurCommand createAkteurCommand) throws PersistenceException, E;
    public void handleAddRoleCommand(PersistentAddRoleCommand addRoleCommand) throws PersistenceException, E;
    public void handleAkteur(PersistentAkteur akteur) throws PersistenceException, E;
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException, E;
    public void handlePosition(PersistentPosition position) throws PersistenceException, E;
    public void handleAuftrag(PersistentAuftrag auftrag) throws PersistenceException, E;
    public void handleAkteurManager(PersistentAkteurManager akteurManager) throws PersistenceException, E;
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException, E;
    public void handleProdukt(PersistentProdukt produkt) throws PersistenceException, E;
    public void handleServer(PersistentServer server) throws PersistenceException, E;
    
}
