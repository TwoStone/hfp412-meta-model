
package view.visitor;
import view.UserException;
import view.*;

public interface MComplexTypeExceptionVisitor<E extends UserException> extends MProductTypeExceptionVisitor<E>,MSumTypeExceptionVisitor<E>{
    
    public void handleMProductType(MProductTypeView mProductType) throws ModelException, E;
    public void handleMSumType(MSumTypeView mSumType) throws ModelException, E;
    
}
