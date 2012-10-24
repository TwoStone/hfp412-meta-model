
package view.visitor;

import view.*;

public interface AbsQuantityReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleQuantity(QuantityView quantity) throws ModelException, E;
    public R handleComposedQuantity(ComposedQuantityView composedQuantity) throws ModelException, E;
    
}
