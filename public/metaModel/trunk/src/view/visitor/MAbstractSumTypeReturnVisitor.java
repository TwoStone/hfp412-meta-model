
package view.visitor;

import view.*;

public interface MAbstractSumTypeReturnVisitor<R> {
    
    public R handleMEmptySumType(MEmptySumTypeView mEmptySumType) throws ModelException;
    public R handleMSumType(MSumTypeView mSumType) throws ModelException;
    
}
