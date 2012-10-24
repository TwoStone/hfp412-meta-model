
package view.visitor;

import view.*;

public abstract class AbsQuantityStandardVisitor implements AbsQuantityVisitor {
    
    public void handleQuantity(QuantityView quantity) throws ModelException{
        this.standardHandling(quantity);
    }
    public void handleComposedQuantity(ComposedQuantityView composedQuantity) throws ModelException{
        this.standardHandling(composedQuantity);
    }
    protected abstract void standardHandling(AbsQuantityView absQuantity) throws ModelException;
}
