
package view.visitor;

import view.*;

public interface MAbstractProductTypeVisitor {
    
    public void handleMProductType(MProductTypeView mProductType) throws ModelException;
    public void handleMEmptyProductType(MEmptyProductTypeView mEmptyProductType) throws ModelException;
    
}
