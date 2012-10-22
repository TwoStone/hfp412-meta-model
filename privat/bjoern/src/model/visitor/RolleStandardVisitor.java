
package model.visitor;

import persistence.*;

public abstract class RolleStandardVisitor implements RolleVisitor {
    
    public void handleLieferant(PersistentLieferant lieferant) throws PersistenceException{
        this.standardHandling(lieferant);
    }
    public void handleKunde(PersistentKunde kunde) throws PersistenceException{
        this.standardHandling(kunde);
    }
    protected abstract void standardHandling(PersistentRolle rolle) throws PersistenceException;
}
