
package view.visitor;

import view.*;

public abstract class MProductTypeStandardVisitor implements MProductTypeVisitor {
    
    public void handleMProductType(MProductTypeView mProductType) throws ModelException{
        this.standardHandling(mProductType);
    }
    public void handleMEmptyProduct(MEmptyProductView mEmptyProduct) throws ModelException{
        this.standardHandling(mEmptyProduct);
    }
    protected abstract void standardHandling(MProductTypeView mProductType) throws ModelException;
}
