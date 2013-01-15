
package view.visitor;

import view.*;

public abstract class MTypeStandardVisitor implements MTypeVisitor {
    
    public void handleMAtomicType(MAtomicTypeView mAtomicType) throws ModelException{
        this.standardHandling(mAtomicType);
    }
    public void handleMProductType(MProductTypeView mProductType) throws ModelException{
        this.standardHandling(mProductType);
    }
    public void handleMEmptySumType(MEmptySumTypeView mEmptySumType) throws ModelException{
        this.standardHandling(mEmptySumType);
    }
    public void handleMEmptyProduct(MEmptyProductView mEmptyProduct) throws ModelException{
        this.standardHandling(mEmptyProduct);
    }
    public void handleMAbstractProductType(MAbstractProductTypeView mAbstractProductType) throws ModelException{
        this.standardHandling(mAbstractProductType);
    }
    public void handleMSumType(MSumTypeView mSumType) throws ModelException{
        this.standardHandling(mSumType);
    }
    protected abstract void standardHandling(MTypeView mType) throws ModelException;
}
