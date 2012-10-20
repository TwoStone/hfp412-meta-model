
package view.visitor;

import view.*;

public interface RolleReturnVisitor<R> {
    
    public R handleLieferant(LieferantView lieferant) throws ModelException;
    public R handleKunde(KundeView kunde) throws ModelException;
    
}
