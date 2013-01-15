
package view.visitor;
import view.UserException;
import view.*;

public interface MAbstractProductTypeExceptionVisitor<E extends UserException> {
    
    public void handleMEmptyProduct(MEmptyProductView mEmptyProduct) throws ModelException, E;
    public void handleMProductType(MProductTypeView mProductType) throws ModelException, E;
    public void handleMAbstractProductType(MAbstractProductTypeView mAbstractProductType) throws ModelException, E;
    
}
