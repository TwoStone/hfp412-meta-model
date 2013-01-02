
package view.visitor;

import view.*;

public interface MSumTypeVisitor {
    
    public void handleMEmptySum(MEmptySumView mEmptySum) throws ModelException;
    public void handleMSumType(MSumTypeView mSumType) throws ModelException;
    
}
