
package model.visitor;

import persistence.*;

public interface RolleReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleLieferant(PersistentLieferant lieferant) throws PersistenceException, E;
    public R handleKunde(PersistentKunde kunde) throws PersistenceException, E;
    
}
