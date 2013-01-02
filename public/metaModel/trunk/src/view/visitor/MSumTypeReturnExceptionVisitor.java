
package view.visitor;
import view.UserException;
import view.*;

public interface MSumTypeReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleMEmptySum(MEmptySumView mEmptySum) throws ModelException, E;
    public R handleMSumType(MSumTypeView mSumType) throws ModelException, E;
    
}
