
package model.visitor;

import persistence.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException;
    
    public abstract void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException;
    
    public abstract void handleAkteur(PersistentAkteur akteur) throws PersistenceException;
    
    public abstract void handleRolle(PersistentRolle rolle) throws PersistenceException;
    
    public void handleLieferant(PersistentLieferant lieferant) throws PersistenceException{
        this.handleRolle(lieferant);
    }
    public void handleKunde(PersistentKunde kunde) throws PersistenceException{
        this.handleRolle(kunde);
    }
    public abstract void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    
    public void handleCreateAkteurCommand(PersistentCreateAkteurCommand createAkteurCommand) throws PersistenceException{
        this.handleCommonDate(createAkteurCommand);
    }
    public void handleAddRoleCommand(PersistentAddRoleCommand addRoleCommand) throws PersistenceException{
        this.handleCommonDate(addRoleCommand);
    }
    public abstract void handlePosition(PersistentPosition position) throws PersistenceException;
    
    public abstract void handleAuftrag(PersistentAuftrag auftrag) throws PersistenceException;
    
    public abstract void handleAkteurManager(PersistentAkteurManager akteurManager) throws PersistenceException;
    
    public abstract void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    
    public abstract void handleProdukt(PersistentProdukt produkt) throws PersistenceException;
    
    public abstract void handleServer(PersistentServer server) throws PersistenceException;
    
    
}
