
package view.visitor;

import view.*;

public abstract class AbsQuantityStandardVisitor implements AbsQuantityVisitor {
    
    public void handleQuantity(QuantityView quantity) throws ModelException{
        this.standardHandling(quantity);
    }
    public void handleCompoundQuantity(CompoundQuantityView compoundQuantity) throws ModelException{
        this.standardHandling(compoundQuantity);
    }
    protected abstract void standardHandling(AbsQuantityView absQuantity) throws ModelException;
}
