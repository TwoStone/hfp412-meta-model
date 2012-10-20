
package model.visitor;

import persistence.*;

public interface RolleVisitor {
    
    public void handleLieferant(PersistentLieferant lieferant) throws PersistenceException;
    public void handleKunde(PersistentKunde kunde) throws PersistenceException;
    
}
