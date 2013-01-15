
package view.visitor;

import view.*;

public interface MQuantiObjectTypeReturnVisitor<R> {
    
    public R handleMAccountType(MAccountTypeView mAccountType) throws ModelException;
    public R handleMMeasurementType(MMeasurementTypeView mMeasurementType) throws ModelException;
    
}
