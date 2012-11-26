
package view.visitor;

import view.*;

public abstract class MTypeStandardVisitor implements MTypeVisitor {
    
    public void handleMAtomicType(MAtomicTypeView mAtomicType) throws ModelException{
        this.standardHandling(mAtomicType);
    }
    public void handleMProductType(MProductTypeView mProductType) throws ModelException{
        this.standardHandling(mProductType);
    }
    public void handleMSumType(MSumTypeView mSumType) throws ModelException{
        this.standardHandling(mSumType);
    }
    protected abstract void standardHandling(MType mType) throws ModelException;
}
