
package model.visitor;

import persistence.*;

public interface RolleExceptionVisitor<E extends model.UserException> {
    
    public void handleLieferant(PersistentLieferant lieferant) throws PersistenceException, E;
    public void handleKunde(PersistentKunde kunde) throws PersistenceException, E;
    
}
