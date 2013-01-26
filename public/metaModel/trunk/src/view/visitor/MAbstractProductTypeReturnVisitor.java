
package view.visitor;

import view.*;

public interface MAbstractProductTypeReturnVisitor<R> {
    
    public R handleMProductType(MProductTypeView mProductType) throws ModelException;
    public R handleMEmptyProductType(MEmptyProductTypeView mEmptyProductType) throws ModelException;
    
}
