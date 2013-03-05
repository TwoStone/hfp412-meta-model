
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentMAccountType;
import persistence.PersistentMMeasurementType;

public interface MQuantiObjectTypeVisitor {
    
    public void handleMAccountType(PersistentMAccountType mAccountType) throws PersistenceException;
    public void handleMMeasurementType(PersistentMMeasurementType mMeasurementType) throws PersistenceException;
    
}
