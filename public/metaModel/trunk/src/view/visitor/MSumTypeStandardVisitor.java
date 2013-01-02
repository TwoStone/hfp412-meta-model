
package view.visitor;

import view.*;

public abstract class MSumTypeStandardVisitor implements MSumTypeVisitor {
    
    public void handleMEmptySum(MEmptySumView mEmptySum) throws ModelException{
        this.standardHandling(mEmptySum);
    }
    public void handleMSumType(MSumTypeView mSumType) throws ModelException{
        this.standardHandling(mSumType);
    }
    protected abstract void standardHandling(MSumTypeView mSumType) throws ModelException;
}
