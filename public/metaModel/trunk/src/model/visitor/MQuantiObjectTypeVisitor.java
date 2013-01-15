
package model.visitor;

import persistence.*;

public interface MQuantiObjectTypeVisitor {
    
    public void handleMMeasurementType(PersistentMMeasurementType mMeasurementType) throws PersistenceException;
    public void handleMAccountType(PersistentMAccountType mAccountType) throws PersistenceException;
    
}
