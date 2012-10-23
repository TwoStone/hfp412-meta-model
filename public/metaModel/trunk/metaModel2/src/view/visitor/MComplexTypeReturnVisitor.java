
package view.visitor;

import view.*;

public interface MComplexTypeReturnVisitor<R> {
    
    public R handleMProductType(MProductTypeView mProductType) throws ModelException;
    public R handleMSumType(MSumTypeView mSumType) throws ModelException;
    
}
