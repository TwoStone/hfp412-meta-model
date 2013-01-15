
package model.visitor;
import model.UserException;
import persistence.*;

public interface MQuantiObjectTypeExceptionVisitor<E extends UserException> {
    
    public void handleMMeasurementType(PersistentMMeasurementType mMeasurementType) throws PersistenceException, E;
    public void handleMAccountType(PersistentMAccountType mAccountType) throws PersistenceException, E;
    
}
