
package model.visitor;

import persistence.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleCreateAkteurCommand(PersistentCreateAkteurCommand createAkteurCommand) throws PersistenceException{
        this.standardHandling(createAkteurCommand);
    }
    public void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException{
        this.standardHandling(commandExecuter);
    }
    public void handleTransactionManager(PersistentTransactionManager transactionManager) throws PersistenceException{
        this.standardHandling(transactionManager);
    }
    public void handleAddRoleCommand(PersistentAddRoleCommand addRoleCommand) throws PersistenceException{
        this.standardHandling(addRoleCommand);
    }
    public void handleAuftrag(PersistentAuftrag auftrag) throws PersistenceException{
        this.standardHandling(auftrag);
    }
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException{
        this.standardHandling(errorDisplay);
    }
    public void handleServer(PersistentServer server) throws PersistenceException{
        this.standardHandling(server);
    }
    public void handleKunde(PersistentKunde kunde) throws PersistenceException{
        this.standardHandling(kunde);
    }
    public void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException{
        this.standardHandling(commandCoordinator);
    }
    public void handleAkteur(PersistentAkteur akteur) throws PersistenceException{
        this.standardHandling(akteur);
    }
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException{
        this.standardHandling(commonDate);
    }
    public void handlePosition(PersistentPosition position) throws PersistenceException{
        this.standardHandling(position);
    }
    public void handleLieferant(PersistentLieferant lieferant) throws PersistenceException{
        this.standardHandling(lieferant);
    }
    public void handleProdukt(PersistentProdukt produkt) throws PersistenceException{
        this.standardHandling(produkt);
    }
    protected abstract void standardHandling(Anything anything) throws PersistenceException;
}
