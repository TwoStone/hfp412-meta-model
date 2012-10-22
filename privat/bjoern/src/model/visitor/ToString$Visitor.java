
package model.visitor;

import persistence.*;

public abstract class ToString$Visitor extends AnythingStandardVisitor{
    
    public abstract void handleTransactionManager(PersistentTransactionManager transactionManager) throws PersistenceException;
    public abstract void handleAuftrag(PersistentAuftrag auftrag) throws PersistenceException;
    public abstract void handleServer(PersistentServer server) throws PersistenceException;
    public abstract void handleKunde(PersistentKunde kunde) throws PersistenceException;
    public abstract void handleAkteur(PersistentAkteur akteur) throws PersistenceException;
    public abstract void handlePosition(PersistentPosition position) throws PersistenceException;
    public abstract void handleLieferant(PersistentLieferant lieferant) throws PersistenceException;
    public abstract void handleProdukt(PersistentProdukt produkt) throws PersistenceException;
    
}
