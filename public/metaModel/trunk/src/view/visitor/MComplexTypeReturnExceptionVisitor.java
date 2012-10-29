
package view.visitor;
import view.UserException;
import view.*;

public interface MComplexTypeReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleMProductType(MProductTypeView mProductType) throws ModelException, E;
    public R handleMSumType(MSumTypeView mSumType) throws ModelException, E;
    
}
