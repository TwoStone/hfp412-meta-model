
package view.visitor;
import view.UserException;
import view.*;

public interface MQuantiObjectTypeExceptionVisitor<E extends UserException> {
    
    public void handleMAccountType(MAccountTypeView mAccountType) throws ModelException, E;
    public void handleMMeasurementType(MMeasurementTypeView mMeasurementType) throws ModelException, E;
    
}
