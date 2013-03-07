
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentMAccountType;
import persistence.PersistentMMeasurementType;

public interface MQuantiObjectTypeReturnVisitor<R> {
    
    public R handleMAccountType(PersistentMAccountType mAccountType) throws PersistenceException;
    public R handleMMeasurementType(PersistentMMeasurementType mMeasurementType) throws PersistenceException;
    
}
