
package view.visitor;

import view.*;

public interface RolleReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleLieferant(LieferantView lieferant) throws ModelException, E;
    public R handleKunde(KundeView kunde) throws ModelException, E;
    
}
