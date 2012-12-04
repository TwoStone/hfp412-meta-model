
package view.visitor;
import view.UserException;
import view.*;

public interface AbsQuantityReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleQuantity(QuantityView quantity) throws ModelException, E;
    public R handleCompoundQuantity(CompoundQuantityView compoundQuantity) throws ModelException, E;
    
}
