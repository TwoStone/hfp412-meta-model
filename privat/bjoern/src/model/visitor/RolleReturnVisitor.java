
package model.visitor;

import persistence.*;

public interface RolleReturnVisitor<R> {
    
    public R handleLieferant(PersistentLieferant lieferant) throws PersistenceException;
    public R handleKunde(PersistentKunde kunde) throws PersistenceException;
    
}
