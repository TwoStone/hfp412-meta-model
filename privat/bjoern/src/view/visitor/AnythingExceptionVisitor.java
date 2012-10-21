
package view.visitor;

import view.*;

public interface AnythingExceptionVisitor<E extends model.UserException> extends RolleExceptionVisitor<E>{
    
    public void handleTransactionManager(TransactionManagerView transactionManager) throws ModelException, E;
    public void handleAuftrag(AuftragView auftrag) throws ModelException, E;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public void handleServer(ServerView server) throws ModelException, E;
    public void handleAkteur(AkteurView akteur) throws ModelException, E;
    public void handlePosition(PositionView position) throws ModelException, E;
    public void handleProdukt(ProduktView produkt) throws ModelException, E;
    
}
