
package view.visitor;
import view.UserException;
import view.*;

public interface MAbstractSumTypeReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleMEmptySumType(MEmptySumTypeView mEmptySumType) throws ModelException, E;
    public R handleMSumType(MSumTypeView mSumType) throws ModelException, E;
    
}
