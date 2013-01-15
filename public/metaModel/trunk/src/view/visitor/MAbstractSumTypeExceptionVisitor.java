
package view.visitor;
import view.UserException;
import view.*;

public interface MAbstractSumTypeExceptionVisitor<E extends UserException> {
    
    public void handleMEmptySumType(MEmptySumTypeView mEmptySumType) throws ModelException, E;
    public void handleMSumType(MSumTypeView mSumType) throws ModelException, E;
    
}
