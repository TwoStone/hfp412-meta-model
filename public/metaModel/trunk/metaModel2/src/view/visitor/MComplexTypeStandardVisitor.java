
package view.visitor;

import view.*;

public abstract class MComplexTypeStandardVisitor implements MComplexTypeVisitor {
    
    public void handleMProductType(MProductTypeView mProductType) throws ModelException{
        this.standardHandling(mProductType);
    }
    public void handleMSumType(MSumTypeView mSumType) throws ModelException{
        this.standardHandling(mSumType);
    }
    protected abstract void standardHandling(MComplexTypeView mComplexType) throws ModelException;
}
