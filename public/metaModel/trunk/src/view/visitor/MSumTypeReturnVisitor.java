
package view.visitor;

import view.*;

public interface MSumTypeReturnVisitor<R> {
    
    public R handleMEmptySum(MEmptySumView mEmptySum) throws ModelException;
    public R handleMSumType(MSumTypeView mSumType) throws ModelException;
    
}
