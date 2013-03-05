
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentMAccountType;
import persistence.PersistentMMeasurementType;

public interface MQuantiObjectTypeReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleMAccountType(PersistentMAccountType mAccountType) throws PersistenceException, E;
    public R handleMMeasurementType(PersistentMMeasurementType mMeasurementType) throws PersistenceException, E;
    
}
