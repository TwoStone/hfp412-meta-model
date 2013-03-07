
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentMObject;
import persistence.PersistentMSingletonObject;

public interface AbstractObjectReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleMObject(PersistentMObject mObject) throws PersistenceException, E;
    public R handleMSingletonObject(PersistentMSingletonObject mSingletonObject) throws PersistenceException, E;
    
}
