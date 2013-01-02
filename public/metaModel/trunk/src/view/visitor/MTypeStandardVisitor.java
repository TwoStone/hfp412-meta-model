
package view.visitor;

import view.*;

public abstract class MTypeStandardVisitor implements MTypeVisitor {
    
    public void handleMAtomicType(MAtomicTypeView mAtomicType) throws ModelException{
        this.standardHandling(mAtomicType);
    }
    public void handleMProductType(MProductTypeView mProductType) throws ModelException{
        this.standardHandling(mProductType);
    }
    public void handleMEmptySum(MEmptySumView mEmptySum) throws ModelException{
        this.standardHandling(mEmptySum);
    }
    public void handleMEmptyProduct(MEmptyProductView mEmptyProduct) throws ModelException{
        this.standardHandling(mEmptyProduct);
    }
    public void handleMSumType(MSumTypeView mSumType) throws ModelException{
        this.standardHandling(mSumType);
    }
    protected abstract void standardHandling(MType mType) throws ModelException;
}
