
package view.visitor;

import view.*;

public interface AbsQuantityVisitor {
    
    public void handleCompoundQuantity(CompoundQuantityView compoundQuantity) throws ModelException;
    public void handleQuantity(QuantityView quantity) throws ModelException;
    
}
