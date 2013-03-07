
package model.visitor;

import persistence.*;

public abstract class MQuantiObjectTypeStandardVisitor implements MQuantiObjectTypeVisitor {
    
    public void handleMMeasurementType(PersistentMMeasurementType mMeasurementType) throws PersistenceException{
        this.standardHandling(mMeasurementType);
    }
    public void handleMAccountType(PersistentMAccountType mAccountType) throws PersistenceException{
        this.standardHandling(mAccountType);
    }
    protected abstract void standardHandling(PersistentMQuantiObjectType mQuantiObjectType) throws PersistenceException;
}
