
package view.visitor;

import view.*;

public abstract class MComplexTypeStandardVisitor implements MComplexTypeVisitor {
    
    public void handleMProductType(MProductTypeView mProductType) throws ModelException{
        this.standardHandling(mProductType);
    }
    public void handleMEmptySumType(MEmptySumTypeView mEmptySumType) throws ModelException{
        this.standardHandling(mEmptySumType);
    }
    public void handleMSumType(MSumTypeView mSumType) throws ModelException{
        this.standardHandling(mSumType);
    }
    public void handleMEmptyProductType(MEmptyProductTypeView mEmptyProductType) throws ModelException{
        this.standardHandling(mEmptyProductType);
    }
    protected abstract void standardHandling(MComplexTypeView mComplexType) throws ModelException;
}
