
package view.visitor;

import view.*;

public abstract class MQuantiObjectTypeStandardVisitor implements MQuantiObjectTypeVisitor {
    
    public void handleMMeasurementType(MMeasurementTypeView mMeasurementType) throws ModelException{
        this.standardHandling(mMeasurementType);
    }
    public void handleMAccountType(MAccountTypeView mAccountType) throws ModelException{
        this.standardHandling(mAccountType);
    }
    protected abstract void standardHandling(MQuantiObjectTypeView mQuantiObjectType) throws ModelException;
}
