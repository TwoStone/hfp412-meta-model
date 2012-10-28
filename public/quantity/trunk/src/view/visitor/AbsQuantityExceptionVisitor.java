
package view.visitor;

import view.*;

public interface AbsQuantityExceptionVisitor<E extends model.UserException> {
    
    public void handleQuantity(QuantityView quantity) throws ModelException, E;
    public void handleComposedQuantity(ComposedQuantityView composedQuantity) throws ModelException, E;
    
}
