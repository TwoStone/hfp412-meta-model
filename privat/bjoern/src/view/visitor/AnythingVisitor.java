
package view.visitor;

import view.*;

public interface AnythingVisitor extends RolleVisitor{
    
    public void handleAkteur(AkteurView akteur) throws ModelException;
    public void handlePosition(PositionView position) throws ModelException;
    public void handleAuftrag(AuftragView auftrag) throws ModelException;
    public void handleAkteurManager(AkteurManagerView akteurManager) throws ModelException;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public void handleProdukt(ProduktView produkt) throws ModelException;
    public void handleServer(ServerView server) throws ModelException;
    
}
