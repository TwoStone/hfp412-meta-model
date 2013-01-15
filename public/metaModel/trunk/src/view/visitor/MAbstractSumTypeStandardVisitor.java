
package view.visitor;

import view.*;

public abstract class MAbstractSumTypeStandardVisitor implements MAbstractSumTypeVisitor {
    
    public void handleMEmptySumType(MEmptySumTypeView mEmptySumType) throws ModelException{
        this.standardHandling(mEmptySumType);
    }
    public void handleMSumType(MSumTypeView mSumType) throws ModelException{
        this.standardHandling(mSumType);
    }
    protected abstract void standardHandling(MAbstractSumTypeView mAbstractSumType) throws ModelException;
}
