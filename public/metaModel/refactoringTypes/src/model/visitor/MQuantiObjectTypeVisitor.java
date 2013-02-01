
package model.visitor;

import persistence.*;

public interface MQuantiObjectTypeVisitor {
    
    public void handleMAccountType(PersistentMAccountType mAccountType) throws PersistenceException;
    public void handleMMeasurementType(PersistentMMeasurementType mMeasurementType) throws PersistenceException;
    
}
