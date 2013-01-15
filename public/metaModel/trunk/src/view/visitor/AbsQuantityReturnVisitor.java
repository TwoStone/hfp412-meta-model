
package view.visitor;

import view.*;

public interface AbsQuantityReturnVisitor<R> {
    
    public R handleCompoundQuantity(CompoundQuantityView compoundQuantity) throws ModelException;
    public R handleQuantity(QuantityView quantity) throws ModelException;
    
}
