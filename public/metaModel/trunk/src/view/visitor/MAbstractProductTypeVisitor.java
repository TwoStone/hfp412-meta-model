
package view.visitor;

import view.*;

public interface MAbstractProductTypeVisitor {
    
    public void handleMEmptyProduct(MEmptyProductView mEmptyProduct) throws ModelException;
    public void handleMProductType(MProductTypeView mProductType) throws ModelException;
    public void handleMAbstractProductType(MAbstractProductTypeView mAbstractProductType) throws ModelException;
    
}
