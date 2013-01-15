
package view.visitor;

import view.*;

public interface MQuantiObjectTypeVisitor {
    
    public void handleMMeasurementType(MMeasurementTypeView mMeasurementType) throws ModelException;
    public void handleMAccountType(MAccountTypeView mAccountType) throws ModelException;
    
}
