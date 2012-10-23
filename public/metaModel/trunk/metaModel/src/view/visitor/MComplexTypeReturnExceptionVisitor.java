
package view.visitor;

import view.*;

public interface MComplexTypeReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleMProductType(MProductTypeView mProductType) throws ModelException, E;
    public R handleMSumType(MSumTypeView mSumType) throws ModelException, E;
    
}
