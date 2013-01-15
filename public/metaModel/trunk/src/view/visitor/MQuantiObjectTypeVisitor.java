
package view.visitor;

import view.*;

public interface MQuantiObjectTypeVisitor {
    
    public void handleMAccountType(MAccountTypeView mAccountType) throws ModelException;
    public void handleMMeasurementType(MMeasurementTypeView mMeasurementType) throws ModelException;
    
}
