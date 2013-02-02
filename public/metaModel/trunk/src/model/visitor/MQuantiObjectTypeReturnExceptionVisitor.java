
package model.visitor;
import model.UserException;
import persistence.*;

public interface MQuantiObjectTypeReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleMAccountType(PersistentMAccountType mAccountType) throws PersistenceException, E;
    public R handleMMeasurementType(PersistentMMeasurementType mMeasurementType) throws PersistenceException, E;
    
}
