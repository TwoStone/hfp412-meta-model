
package view.visitor;
import view.UserException;
import view.*;

public interface MComplexTypeExceptionVisitor<E extends UserException> extends MAbstractSumTypeExceptionVisitor<E>,MAbstractProductTypeExceptionVisitor<E>{
    
    public void handleMAbstractProductType(MAbstractProductTypeView mAbstractProductType) throws ModelException, E;
    
}
