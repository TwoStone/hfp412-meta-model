
package view.visitor;

import view.*;

public interface AnythingReturnVisitor<R> extends RolleReturnVisitor<R> {
    
    public R handleAkteur(AkteurView akteur) throws ModelException;
    public R handlePosition(PositionView position) throws ModelException;
    public R handleAuftrag(AuftragView auftrag) throws ModelException;
    public R handleAkteurManager(AkteurManagerView akteurManager) throws ModelException;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public R handleProdukt(ProduktView produkt) throws ModelException;
    public R handleServer(ServerView server) throws ModelException;
    
}
