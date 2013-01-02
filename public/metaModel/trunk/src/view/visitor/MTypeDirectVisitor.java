
package view.visitor;

import view.*;

public abstract class MTypeDirectVisitor implements MTypeVisitor {
    
    public abstract void handleMAtomicType(MAtomicTypeView mAtomicType) throws ModelException;
    
    public abstract void handleMComplexType(MComplexTypeView mComplexType) throws ModelException;
    
    public void handleMProductType(MProductTypeView mProductType) throws ModelException{
        this.handleMComplexType(mProductType);
    }
    public void handleMEmptySum(MEmptySumView mEmptySum) throws ModelException{
        this.handleMComplexType(mEmptySum);
    }
    public void handleMEmptyProduct(MEmptyProductView mEmptyProduct) throws ModelException{
        this.handleMComplexType(mEmptyProduct);
    }
    public void handleMSumType(MSumTypeView mSumType) throws ModelException{
        this.handleMComplexType(mSumType);
    }
    
}
