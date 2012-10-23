
package view.visitor;

import view.*;

public interface MComplexTypeExceptionVisitor<E extends model.UserException> {
    
    public void handleMProductType(MProductTypeView mProductType) throws ModelException, E;
    public void handleMSumType(MSumTypeView mSumType) throws ModelException, E;
    
}
