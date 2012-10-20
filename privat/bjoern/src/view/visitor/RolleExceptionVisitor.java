
package view.visitor;

import view.*;

public interface RolleExceptionVisitor<E extends model.UserException> {
    
    public void handleLieferant(LieferantView lieferant) throws ModelException, E;
    public void handleKunde(KundeView kunde) throws ModelException, E;
    
}
