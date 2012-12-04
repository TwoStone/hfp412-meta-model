
package view.visitor;
import view.UserException;
import view.*;

public interface MComplexTypeExceptionVisitor<E extends UserException> {
    
    public void handleMProductType(MProductTypeView mProductType) throws ModelException, E;
    public void handleMSumType(MSumTypeView mSumType) throws ModelException, E;
    
}
