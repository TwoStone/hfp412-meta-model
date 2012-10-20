
package view.visitor;

import view.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleAkteur(AkteurView akteur) throws ModelException;
    
    public abstract void handleRolle(RolleView rolle) throws ModelException;
    
    public void handleLieferant(LieferantView lieferant) throws ModelException{
        this.handleRolle(lieferant);
    }
    public void handleKunde(KundeView kunde) throws ModelException{
        this.handleRolle(kunde);
    }
    public abstract void handlePosition(PositionView position) throws ModelException;
    
    public abstract void handleAuftrag(AuftragView auftrag) throws ModelException;
    
    public abstract void handleAkteurManager(AkteurManagerView akteurManager) throws ModelException;
    
    public abstract void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    
    public abstract void handleProdukt(ProduktView produkt) throws ModelException;
    
    public abstract void handleServer(ServerView server) throws ModelException;
    
    
}
