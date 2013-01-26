
package view.visitor;

import view.*;

public abstract class MAbstractProductTypeStandardVisitor implements MAbstractProductTypeVisitor {
    
    public void handleMProductType(MProductTypeView mProductType) throws ModelException{
        this.standardHandling(mProductType);
    }
    public void handleMEmptyProductType(MEmptyProductTypeView mEmptyProductType) throws ModelException{
        this.standardHandling(mEmptyProductType);
    }
    protected abstract void standardHandling(MAbstractProductTypeView mAbstractProductType) throws ModelException;
}
