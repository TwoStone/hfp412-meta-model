
package view.visitor;
import view.UserException;
import view.*;

public interface MSumTypeExceptionVisitor<E extends UserException> {
    
    public void handleMEmptySum(MEmptySumView mEmptySum) throws ModelException, E;
    public void handleMSumType(MSumTypeView mSumType) throws ModelException, E;
    
}
