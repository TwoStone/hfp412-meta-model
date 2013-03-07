
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentMAccountType;
import persistence.PersistentMMeasurementType;
import persistence.PersistentMQuantiObjectType;

public abstract class MQuantiObjectTypeStandardVisitor implements MQuantiObjectTypeVisitor {
    
    public void handleMMeasurementType(PersistentMMeasurementType mMeasurementType) throws PersistenceException{
        this.standardHandling(mMeasurementType);
    }
    public void handleMAccountType(PersistentMAccountType mAccountType) throws PersistenceException{
        this.standardHandling(mAccountType);
    }
    protected abstract void standardHandling(PersistentMQuantiObjectType mQuantiObjectType) throws PersistenceException;
}
