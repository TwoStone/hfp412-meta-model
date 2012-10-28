
package view.visitor;

import view.*;

public interface AbsQuantityReturnVisitor<R> {
    
    public R handleQuantity(QuantityView quantity) throws ModelException;
    public R handleComposedQuantity(ComposedQuantityView composedQuantity) throws ModelException;
    
}
