
package view.visitor;

import view.*;

public interface MQuantiObjectTypeReturnVisitor<R> {
    
    public R handleMMeasurementType(MMeasurementTypeView mMeasurementType) throws ModelException;
    public R handleMAccountType(MAccountTypeView mAccountType) throws ModelException;
    
}
