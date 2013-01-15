
package model.visitor;

import persistence.*;

public interface MQuantiObjectTypeReturnVisitor<R> {
    
    public R handleMMeasurementType(PersistentMMeasurementType mMeasurementType) throws PersistenceException;
    public R handleMAccountType(PersistentMAccountType mAccountType) throws PersistenceException;
    
}
