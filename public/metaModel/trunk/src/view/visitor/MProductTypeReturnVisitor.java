
package view.visitor;

import view.*;

public interface MProductTypeReturnVisitor<R> {
    
    public R handleMEmptyProduct(MEmptyProductView mEmptyProduct) throws ModelException;
    public R handleMProductType(MProductTypeView mProductType) throws ModelException;
    
}
