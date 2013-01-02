
package view.visitor;

import view.*;

public interface MProductTypeVisitor {
    
    public void handleMEmptyProduct(MEmptyProductView mEmptyProduct) throws ModelException;
    public void handleMProductType(MProductTypeView mProductType) throws ModelException;
    
}
