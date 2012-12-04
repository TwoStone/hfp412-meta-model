
package model.visitor;
import model.UserException;
import persistence.*;

public interface MBooleanReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleMFalse(PersistentMFalse mFalse) throws PersistenceException, E;
    public R handleMTrue(PersistentMTrue mTrue) throws PersistenceException, E;
    public R handleMBoolean(PersistentMBoolean mBoolean) throws PersistenceException, E;
    
}
