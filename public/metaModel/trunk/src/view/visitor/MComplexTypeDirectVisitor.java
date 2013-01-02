
package view.visitor;

import view.*;

public abstract class MComplexTypeDirectVisitor implements MComplexTypeVisitor {
    
    public abstract void handleMProductType(MProductTypeView mProductType) throws ModelException;
    
    public void handleMEmptyProduct(MEmptyProductView mEmptyProduct) throws ModelException{
        this.handleMProductType(mEmptyProduct);
    }
    public abstract void handleMSumType(MSumTypeView mSumType) throws ModelException;
    
    public void handleMEmptySum(MEmptySumView mEmptySum) throws ModelException{
        this.handleMSumType(mEmptySum);
    }
    
}
