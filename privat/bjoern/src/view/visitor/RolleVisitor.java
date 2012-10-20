
package view.visitor;

import view.*;

public interface RolleVisitor {
    
    public void handleLieferant(LieferantView lieferant) throws ModelException;
    public void handleKunde(KundeView kunde) throws ModelException;
    
}
