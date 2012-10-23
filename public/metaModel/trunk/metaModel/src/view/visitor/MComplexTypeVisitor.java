
package view.visitor;

import view.*;

public interface MComplexTypeVisitor {
    
    public void handleMProductType(MProductTypeView mProductType) throws ModelException;
    public void handleMSumType(MSumTypeView mSumType) throws ModelException;
    
}
