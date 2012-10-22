
package view.visitor;

import view.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleTransactionManager(TransactionManagerView transactionManager) throws ModelException{
        this.standardHandling(transactionManager);
    }
    public void handleAuftrag(AuftragView auftrag) throws ModelException{
        this.standardHandling(auftrag);
    }
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException{
        this.standardHandling(errorDisplay);
    }
    public void handleServer(ServerView server) throws ModelException{
        this.standardHandling(server);
    }
    public void handleKunde(KundeView kunde) throws ModelException{
        this.standardHandling(kunde);
    }
    public void handleAkteur(AkteurView akteur) throws ModelException{
        this.standardHandling(akteur);
    }
    public void handlePosition(PositionView position) throws ModelException{
        this.standardHandling(position);
    }
    public void handleLieferant(LieferantView lieferant) throws ModelException{
        this.standardHandling(lieferant);
    }
    public void handleProdukt(ProduktView produkt) throws ModelException{
        this.standardHandling(produkt);
    }
    protected abstract void standardHandling(Anything anything) throws ModelException;
}
