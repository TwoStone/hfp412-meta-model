
package view.visitor;

import view.*;

public interface AnythingReturnExceptionVisitor<R, E extends model.UserException> extends RolleReturnExceptionVisitor<R, E> {
    
    public R handleAkteur(AkteurView akteur) throws ModelException, E;
    public R handlePosition(PositionView position) throws ModelException, E;
    public R handleAuftrag(AuftragView auftrag) throws ModelException, E;
    public R handleAkteurManager(AkteurManagerView akteurManager) throws ModelException, E;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public R handleProdukt(ProduktView produkt) throws ModelException, E;
    public R handleServer(ServerView server) throws ModelException, E;
    
}
