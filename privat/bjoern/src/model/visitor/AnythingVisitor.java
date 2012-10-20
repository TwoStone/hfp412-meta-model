
package model.visitor;

import persistence.*;

public interface AnythingVisitor extends CommonDateVisitor,RolleVisitor{
    
    public void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException;
    public void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException;
    public void handleCreateAkteurCommand(PersistentCreateAkteurCommand createAkteurCommand) throws PersistenceException;
    public void handleAddRoleCommand(PersistentAddRoleCommand addRoleCommand) throws PersistenceException;
    public void handleAkteur(PersistentAkteur akteur) throws PersistenceException;
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    public void handlePosition(PersistentPosition position) throws PersistenceException;
    public void handleAuftrag(PersistentAuftrag auftrag) throws PersistenceException;
    public void handleAkteurManager(PersistentAkteurManager akteurManager) throws PersistenceException;
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public void handleProdukt(PersistentProdukt produkt) throws PersistenceException;
    public void handleServer(PersistentServer server) throws PersistenceException;
    
}
