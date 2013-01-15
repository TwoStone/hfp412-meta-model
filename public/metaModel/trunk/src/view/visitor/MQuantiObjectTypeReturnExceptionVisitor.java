
package view.visitor;
import view.UserException;
import view.*;

public interface MQuantiObjectTypeReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleMMeasurementType(MMeasurementTypeView mMeasurementType) throws ModelException, E;
    public R handleMAccountType(MAccountTypeView mAccountType) throws ModelException, E;
    
}
