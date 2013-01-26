
package view.visitor;
import view.UserException;
import view.*;

public interface MAbstractProductTypeReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleMProductType(MProductTypeView mProductType) throws ModelException, E;
    public R handleMEmptyProductType(MEmptyProductTypeView mEmptyProductType) throws ModelException, E;
    
}
