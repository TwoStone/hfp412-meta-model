
package view.visitor;
import view.UserException;
import view.*;

public interface MProductTypeReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleMEmptyProduct(MEmptyProductView mEmptyProduct) throws ModelException, E;
    public R handleMProductType(MProductTypeView mProductType) throws ModelException, E;
    
}
