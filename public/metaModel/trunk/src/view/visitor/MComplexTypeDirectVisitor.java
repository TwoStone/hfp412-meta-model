
package view.visitor;

import view.*;

public abstract class MComplexTypeDirectVisitor implements MComplexTypeVisitor {
    
    public abstract void handleMAbstractSumType(MAbstractSumTypeView mAbstractSumType) throws ModelException;
    
    public void handleMEmptySumType(MEmptySumTypeView mEmptySumType) throws ModelException{
        this.handleMAbstractSumType(mEmptySumType);
    }
    public void handleMSumType(MSumTypeView mSumType) throws ModelException{
        this.handleMAbstractSumType(mSumType);
    }
    public abstract void handleMAbstractProductType(MAbstractProductTypeView mAbstractProductType) throws ModelException;
    
    public void handleMProductType(MProductTypeView mProductType) throws ModelException{
        this.handleMAbstractProductType(mProductType);
    }
    public void handleMEmptyProductType(MEmptyProductTypeView mEmptyProductType) throws ModelException{
        this.handleMAbstractProductType(mEmptyProductType);
    }
    
}
