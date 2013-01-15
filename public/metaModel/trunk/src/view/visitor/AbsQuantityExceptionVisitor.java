
package view.visitor;
import view.UserException;
import view.*;

public interface AbsQuantityExceptionVisitor<E extends UserException> {
    
    public void handleCompoundQuantity(CompoundQuantityView compoundQuantity) throws ModelException, E;
    public void handleQuantity(QuantityView quantity) throws ModelException, E;
    
}
