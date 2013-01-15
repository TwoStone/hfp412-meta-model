
package view.visitor;

import view.*;

public interface MAbstractProductTypeReturnVisitor<R> {
    
    public R handleMEmptyProduct(MEmptyProductView mEmptyProduct) throws ModelException;
    public R handleMProductType(MProductTypeView mProductType) throws ModelException;
    public R handleMAbstractProductType(MAbstractProductTypeView mAbstractProductType) throws ModelException;
    
}
