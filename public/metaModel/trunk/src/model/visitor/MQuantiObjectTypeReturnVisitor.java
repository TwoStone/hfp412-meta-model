
package model.visitor;

import persistence.*;

public interface MQuantiObjectTypeReturnVisitor<R> {
    
    public R handleMAccountType(PersistentMAccountType mAccountType) throws PersistenceException;
    public R handleMMeasurementType(PersistentMMeasurementType mMeasurementType) throws PersistenceException;
    
}
