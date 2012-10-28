
package view.visitor;

import view.*;

public interface AbsQuantityVisitor {
    
    public void handleQuantity(QuantityView quantity) throws ModelException;
    public void handleComposedQuantity(ComposedQuantityView composedQuantity) throws ModelException;
    
}
