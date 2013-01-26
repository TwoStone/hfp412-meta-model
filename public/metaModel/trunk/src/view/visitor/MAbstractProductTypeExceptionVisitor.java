
package view.visitor;
import view.UserException;
import view.*;

public interface MAbstractProductTypeExceptionVisitor<E extends UserException> {
    
    public void handleMProductType(MProductTypeView mProductType) throws ModelException, E;
    public void handleMEmptyProductType(MEmptyProductTypeView mEmptyProductType) throws ModelException, E;
    
}
