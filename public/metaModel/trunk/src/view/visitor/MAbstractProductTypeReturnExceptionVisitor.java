
package view.visitor;
import view.UserException;
import view.*;

public interface MAbstractProductTypeReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleMEmptyProduct(MEmptyProductView mEmptyProduct) throws ModelException, E;
    public R handleMProductType(MProductTypeView mProductType) throws ModelException, E;
    public R handleMAbstractProductType(MAbstractProductTypeView mAbstractProductType) throws ModelException, E;
    
}
