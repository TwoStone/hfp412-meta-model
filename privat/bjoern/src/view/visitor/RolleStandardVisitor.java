
package view.visitor;

import view.*;

public abstract class RolleStandardVisitor implements RolleVisitor {
    
    public void handleLieferant(LieferantView lieferant) throws ModelException{
        this.standardHandling(lieferant);
    }
    public void handleKunde(KundeView kunde) throws ModelException{
        this.standardHandling(kunde);
    }
    protected abstract void standardHandling(RolleView rolle) throws ModelException;
}
