
package view.visitor;

import view.*;

public abstract class MAbstractProductTypeStandardVisitor implements MAbstractProductTypeVisitor {
    
    public void handleMProductType(MProductTypeView mProductType) throws ModelException{
        this.standardHandling(mProductType);
    }
    public void handleMEmptyProduct(MEmptyProductView mEmptyProduct) throws ModelException{
        this.standardHandling(mEmptyProduct);
    }
    public void handleMAbstractProductType(MAbstractProductTypeView mAbstractProductType) throws ModelException{
        this.standardHandling(mAbstractProductType);
    }
    protected abstract void standardHandling(MAbstractProductTypeView mAbstractProductType) throws ModelException;
}
