
package model.visitor;
import model.UserException;
import persistence.*;

public interface AbstractObjectReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleMObject(PersistentMObject mObject) throws PersistenceException, E;
    public R handleMSingletonObject(PersistentMSingletonObject mSingletonObject) throws PersistenceException, E;
    
}
